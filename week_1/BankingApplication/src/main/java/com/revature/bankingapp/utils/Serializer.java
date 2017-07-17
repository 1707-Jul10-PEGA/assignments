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

	public void writePersonToDb(Person p) throws FileNotFoundException, ClassNotFoundException, IOException {

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
			personList = getDb(selectedDb);
		}

		personList.add(p);

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(selectedDb));
		out.writeObject(personList);
		out.close();

	}

	/**
	 * Saves new created account into database
	 * 
	 * @param a
	 *            -Bank Account object to be added
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void saveAccountToDb(BankAccount a) throws FileNotFoundException, ClassNotFoundException, IOException {

		String selectedDb = "";
		ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();

		/* Where to write depending on the type of Person */
		if (a instanceof CheckingAccount) {
			selectedDb = checkingDatabase;

		}

		else if (a instanceof SavingsAccount) {
			selectedDb = savingsDatabase;

		}

		File file = new File(selectedDb);
		if (file.exists()) {
			accountList = getDb(selectedDb);
		}

		accountList.add(a);

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(selectedDb));
		out.writeObject(accountList);
		out.close();

	}

	/**
	 * Generic return type. Used to get an ArrayList of Person
	 * 
	 * @param db
	 *            -Path to file.
	 * @return - generic
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public <T> T getDb(String db) throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(db));
		T personList = (T) ois.readObject();

		return personList;

	}

	/**
	 * Returns list of Accounts. Can return both savings or checking.
	 * 
	 * @param db
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public <T> T getAccounts(String db) throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(db));
		T bankAccount = (T) ois.readObject();

		return bankAccount;

	}

	public SavingsAccount getSavingAccounts(UUID userid)
			throws FileNotFoundException, ClassNotFoundException, IOException {

		ArrayList<SavingsAccount> saving = getAccounts(savingsDatabase);
		
		for (SavingsAccount sa : saving) {
			if (sa.getOwnerId().equals(userid)) {
				return sa;
			}
		}

		return null;
	}

	public CheckingAccount getCheckingAccounts(UUID userid)
			throws FileNotFoundException, ClassNotFoundException, IOException {

		ArrayList<CheckingAccount> checking = getAccounts(checkingDatabase);
		
		for (CheckingAccount ca : checking) {
			if (ca.getOwnerId().equals(userid)) {
				return ca;
			}
		}

		return null;

	}

	public <T> T getPersonList(String type) throws FileNotFoundException, ClassNotFoundException, IOException {

		String database = "";

		switch (type) {
		case "customer":
			database = customerDatabase;
			break;
		case "employee":
			database = employeeDatabase;
			break;
		case "admin":
			database = adminDatabase;
			break;

		default:
			break;
		}

		return getDb(database);
	}

}
