package com.revature.bankingapp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.GenericArrayType;
import java.rmi.Remote;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.entities.account.CheckingAccount;
import com.revature.bankingapp.entities.account.SavingsAccount;
import com.revature.bankingapp.entities.person.*;

public class Serializer<T> {

	private String customerDatabase = "src/main/java/com/revature/bankingapp/resources/database/customer.txt";
	private String adminDatabase = "src/main/java/com/revature/bankingapp/resources/database/administrator.txt";
	private String employeeDatabase = "src/main/java/com/revature/bankingapp/resources/database/employee.txt";

	private String savingsDatabase = "src/main/java/com/revature/bankingapp/resources/database/savings.txt";
	private String checkingDatabase = "src/main/java/com/revature/bankingapp/resources/database/checking.txt";

	private CheckingAccount internalChecking = new CheckingAccount();
	private SavingsAccount internalSaving = new SavingsAccount();

	private ArrayList<BankAccount> allCheckingAccounts = new ArrayList<BankAccount>();
	private ArrayList<BankAccount> allSavingsAccounts = new ArrayList<BankAccount>();
	
	public void generatePersonAccounts() throws FileNotFoundException, ClassNotFoundException, IOException {
		Customer c = new Customer("Martin", "Delira", "mdelira", "lv223", "07-08-1990", "123 7th");
		Employee e = new Employee("John", "Delira","johnD","tkt" ,"07-08-1987", "123 8th");
		Administrator a = new Administrator("Martin", "Admin", "adminMartin", "adminrules", "01-01-1990", "123 10th");
				
		this.persist(c);
		this.persist(e);
		this.persist(a);
	}
	

	public void loadDatabase() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		
		File savingDbFile = new File(savingsDatabase);
		File checkingFile = new File(checkingDatabase);
		
		if(savingDbFile.exists()) {
			if(savingDbFile.length()!=0) {
				this.allSavingsAccounts = new ArrayList<BankAccount>();
				this.allSavingsAccounts = getAccountsDatabase(savingsDatabase);
			}
			
		}
		if(checkingFile.exists()) {
			if(checkingFile.length()!=0) {
				this.allCheckingAccounts = new ArrayList<BankAccount>();
				this.allCheckingAccounts = getAccountsDatabase(checkingDatabase);	
			}
		}	
	}

	public ArrayList<BankAccount> getAllCheckingAccounts() {
		return allCheckingAccounts;
	}

	public ArrayList<BankAccount> getAllSavingsAccounts() {
		return allSavingsAccounts;
	}

	public String internalAccountsToString() {
		return allCheckingAccounts.toString() + "\n\n " + allSavingsAccounts.toString();
	}

	public int persist(Person p) throws FileNotFoundException, ClassNotFoundException, IOException {

		String selectedDb = "";
		ArrayList<Person> personList = new ArrayList<Person>();

		/* Where to write depending on the type of Person */
		if (p instanceof Customer) {
			selectedDb = customerDatabase;
		}

		else if (p instanceof Administrator) {
			selectedDb = adminDatabase;
		}

		else if (p instanceof Employee) {
			selectedDb = employeeDatabase;
		}

		File file = new File(selectedDb);
		if (file.exists()) {
			if(file.length() != 0) {
				personList = getDatabase(selectedDb);	
			}
			
		} else if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}

		personList.add(p);

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(selectedDb));
		out.writeObject(personList);
		out.close();
		return 0;

	}

	public void persist(BankAccount b) throws FileNotFoundException, ClassNotFoundException, IOException {

		String selectedDb = "";
		ArrayList<BankAccount> accountsList = new ArrayList<BankAccount>();

		/* Where to write depending on the type of Person */
		if (b instanceof SavingsAccount) {
			selectedDb = savingsDatabase;
		}

		else if (b instanceof CheckingAccount) {
			selectedDb = checkingDatabase;
		}

		File file = new File(selectedDb);
		if (file.exists()) {
			accountsList = getDatabase(selectedDb);
			// accountsList.remove(b);
			accountsList.add(b);

		} else if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(selectedDb));
		out.writeObject(accountsList);
		out.close();

	}

	public <T> T getDatabase(String db) throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(db));
		T personList = (T) ois.readObject();
		ois.close();

		return personList;
	}

	public boolean saveAccounts(ArrayList<BankAccount> allAccounts, String databaseName)
			throws FileNotFoundException, IOException {

		File file = new File(databaseName);
		if (file.exists()) {

			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(databaseName));
			out.writeObject(allAccounts);
			out.close();
			return true;

		} else if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(databaseName));
			out.writeObject(allAccounts);
			out.close();
			return true;
		}

		return false;
	}

	public BankAccount getBankAccount(UUID userid, Class accountType)
			throws FileNotFoundException, ClassNotFoundException, IOException {

		ArrayList<BankAccount> listOfAllAccounts = new ArrayList<BankAccount>();

		BankAccount myAccount = new BankAccount();
		BankAccount tmp = new BankAccount();

		String databasePath = null;

		if (accountType.getName().equals("CheckingAccount")) {
			databasePath = checkingDatabase;
		}
		if (accountType.getName().equals("SavingsAccount")) {
			databasePath = savingsDatabase;
		}

		File file = new File(databasePath);
		if (file.exists()) {
			if (file.length() != 0) {

				listOfAllAccounts = getAccountsDatabase(databasePath);

				for (BankAccount ba : listOfAllAccounts) {
					if (ba.getOwnerId().equals(userid)) {
						myAccount = ba;
					}
				}

				listOfAllAccounts.remove(myAccount);
				saveAccounts(listOfAllAccounts, databasePath);
				return myAccount;
			}
		}

		return null;

	}

	public ArrayList<Person> getPersonDatabase(String type)
			throws FileNotFoundException, ClassNotFoundException, IOException {

		String database = "";
		ArrayList<Person> personDatabase = new ArrayList<Person>();

		switch (type) {
		case "customer":
			database = customerDatabase;
			break;
		case "employee":
			database = employeeDatabase;
			break;
		case "administrator":
			database = adminDatabase;
			break;

		default:
			break;
		}

		File file = new File(database);
		if (file.exists()) {
			if (file.length() != 0) {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(database));
			    personDatabase = (ArrayList<Person>) ois.readObject();
				ois.close();

			}
		} else {
			System.out.println("Datbase missing");
			file.getParentFile().mkdirs();
			file.createNewFile();
		}

		return personDatabase;

	}

	public ArrayList<BankAccount> getAccountsDatabase(String db)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(db));
		ArrayList<BankAccount> bankAccountsDatabase = (ArrayList<BankAccount>) ois.readObject();
		ois.close();

		return bankAccountsDatabase;

	}

	public ArrayList<T> getDatabase(T t) throws FileNotFoundException, IOException, ClassNotFoundException {
		String db = "";
		if (t instanceof Customer) {
			db = customerDatabase;
		}
		if (t instanceof Employee) {
			db = employeeDatabase;
		}
		if (t instanceof Administrator) {
			db = adminDatabase;
		}
		if (t instanceof SavingsAccount) {
			db = savingsDatabase;
		}
		if (t instanceof CheckingAccount) {
			db = checkingDatabase;
		}

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(db));
		ArrayList<BankAccount> database = (ArrayList<BankAccount>) ois.readObject();
		ois.close();

		return (ArrayList<T>) database;

	}

	public CheckingAccount getCheckingAccount(UUID userId) {
		// TODO Auto-generated method stub
		BankAccount tmp = null;
		if (allCheckingAccounts != null) {
			for (BankAccount ch : allCheckingAccounts) {
				if (ch.getOwnerId().equals(userId)) {
					tmp = ch;
				}
			}
			allCheckingAccounts.remove(tmp);
			return (CheckingAccount) tmp;
		}

		return null;
	}

	public SavingsAccount getSavingsAccount(UUID userId) {
		// TODO Auto-generated method stub
		BankAccount tmp = null;
		if (allSavingsAccounts != null) {
			for (BankAccount sa : allSavingsAccounts) {
				if (sa.getOwnerId().equals(userId)) {
					tmp = sa;
				}
			}
			allSavingsAccounts.remove(tmp);
			return (SavingsAccount) tmp;
		}

		return null;
	}

	public void flush(SavingsAccount savingsAccount) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		allSavingsAccounts.add(savingsAccount);
		saveAccounts(allSavingsAccounts, savingsDatabase);

	}

	public void flush(CheckingAccount checkingAccount) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		allCheckingAccounts.add(checkingAccount);
		saveAccounts(allCheckingAccounts, checkingDatabase);

	}

	public boolean databaseExist(String type) {
		// TODO Auto-generated method stub
		if(type.equals("customer")) {
			type = customerDatabase;
		}
		if(type.equals("employee")) {
			type = employeeDatabase;
		}
		if(type.equals("administrator")) {
			type = adminDatabase;
		}
		
		File file = new File(type);
		if (file.exists()) {
			return true;
		} else if (!file.exists()) {
			
		}

		return false;
	}

}
