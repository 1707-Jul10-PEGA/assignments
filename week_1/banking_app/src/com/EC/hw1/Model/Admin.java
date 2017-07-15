package com.EC.hw1.Model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.EC.hw1.Interfaces.AdminInterface;
import com.EC.hw1.Utilities.BankUtilities;

public class Admin extends User implements AdminInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7689680374583441970L;
	private static Scanner scan = new Scanner(System.in);
	private Account account;

	public Admin() {
		super();
	}

	public Admin(String firstName, String lastName, String userName, String password, Account account) {
		super(firstName, lastName, userName, password);
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public void viewAllAccounts() {
		List<User> userList = new LinkedList<User>();
		getAllUsers((LinkedList<User>) userList);
		for (User u : userList) {
			if (u instanceof Customer) {
				System.out.println("CUSTOMER");
				System.out.println(((Customer) u).toString());
				((Customer) u).viewBalance();
			} else if (u instanceof Employee) {
				System.out.println("EMPLOYEE");
				System.out.println(((Employee) u).toString() + "\n");
			}
		}

	}

	@Override
	public void editAccount() {
		System.out.println("Account username you would to edit:");
		String username = scan.next();
		User user = BankUtilities.readUser(username);
		boolean valid = true;

		while (valid) {
			if (user != null && user instanceof Customer) {
				System.out.println("Please enter a number between 1-9 to continue");
				printUserEdit();
				printCustomerEdit();
				if (scan.hasNextInt()) {
					int tmp = scan.nextInt();
					switch (tmp) {
					case 1:
						editFirstName(user);
						break;
					case 2:
						editLastName(user);
						break;
					case 3:
						editPassword(user);
						break;
					case 4:
						editEmail((Customer) user);
						break;
					case 5:
						editUserName(user);
						break;
					case 6:
						editCheckingAccount((Customer) user);
						break;
					case 7:
						editSavingAccount((Customer) user);
						break;
					case 8:
						editCreditAccount((Customer) user);
						break;
					case 9:
						valid = false;
						break;
					}
				}

			} else if (user != null && user instanceof Employee) {
				System.out.println("Please enter a number between 1-7 to continue");
				printUserEdit();
				printEmployeeEdit();
				if (scan.hasNextInt()) {
					int tmp = scan.nextInt();
					switch (tmp) {
					case 1:
						editFirstName(user);
						break;
					case 2:
						editLastName(user);
						break;
					case 3:
						editPassword(user);
						break;
					case 4:
						editEmail((Employee) user);
						break;
					case 5:
						editUserName(user);
						break;
					case 6:
						editEmployeesClients((Employee) user);
						break;
					case 7:
						valid = false;
						break;
					}
				}
			}
		}

	}

	private static void editEmployeesClients(Employee e) {
		boolean valid = true;

		while (valid) {
			System.out.println("Please enter 1-3 to continue");
			System.out.println("(1)Add Client");
			System.out.println("(2)Remove Client");
			System.out.println("(3)View Employee's Clients");
			System.out.println("(4)Back");
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				switch (tmp) {
				case 1:
					addClient(e);
					break;
				case 2:
					removeClient(e);
				case 3:
					e.viewCustomerList();
					break;
				case 4:
					valid = true;
					break;
				}
			}
		}

	}

	private static void removeClient(Employee e) {
		System.out.println("Please enter the Client's username that you would like to remove");
		String username = scan.next();
		if(BankUtilities.accountExist(username)){
			Customer c = (Customer) BankUtilities.readUser(username);
			if(e.getCustList().contains(c)){
				e.getCustList().remove(c);
			}else{
				System.out.println("This client is not assigned to this employee");
			}
			
		}else{
			System.out.println(username + " does not exist in our database. Please try another username");
		}
		
	}

	private static void addClient(Employee e) {
		System.out.println("Please enter the Customer's username that you would like to add");
		String username = scan.next();
		if(BankUtilities.accountExist(username)){
			Customer c = (Customer) BankUtilities.readUser(username);
			if(e.getCustList().contains(c)){
				System.out.println("This client is already assigned to this employee");
			}else{
				e.addCustomer(c);
				updateFiles(e);
			}
		}else{
			System.out.println(username + " does not exist in our database. Please try another username");
		}
		
	}

	private void getAllUsers(LinkedList<User> userList) {
		File folder = new File("Users/");
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length == 0) {
			System.out.println("No users exist!");
			return;
		} else {
			for (File f : listOfFiles) {
				userList.add(BankUtilities.readUser(f.getPath()));
			}
		}
	}

	private static void updateFiles(User u) {
		if (u instanceof Employee) {
			BankUtilities.writeEmployee((Employee) u);
			BankUtilities.writeUser((Employee) u);
		} else {
			BankUtilities.writeUser((Customer) u);
		}
	}

	private static void editFirstName(User u) {
		System.out.println("Enter new first name");
		u.setFirstName(scan.next());
		updateFiles(u);
	}

	private static void editLastName(User u) {
		System.out.println("Enter new last name");
		u.setLastName(scan.next());
		updateFiles(u);
	}

	private static void editPassword(User u) {
		System.out.println("Enter new password");
		u.setPassword(scan.next());
		updateFiles(u);
	}

	private static void editEmail(User u) {
		System.out.println("Enter new email address");
		if (u instanceof Customer) {
			((Customer) u).getBankAccount().setEmail(scan.next());
			updateFiles(u);
		} else {
			((Employee) u).getAccount().setEmail(scan.next());
			updateFiles(u);
		}

	}

	private static void editUserName(User u) {
		boolean valid = true;
		String oldUserName = u.getUserName();
		while (valid) {
			System.out.println("Enter new username");
			String username = scan.next();
			if (BankUtilities.accountExist(username)) {
				System.out.println("Username is already taken. Please pick a different one.");
			} else {
				u.setUserName(username);
				updateFiles(u);
				valid = true;
				if (u instanceof Employee) {
					Path path1 = Paths.get("Empolyees/", oldUserName, ".txt");
					BankUtilities.deleteUser(path1);
				}
				Path path2 = Paths.get("Users/", oldUserName, ".txt");
				BankUtilities.deleteUser(path2);
			}
		}
	}

	private static void editCheckingAccount(Customer c) {
		boolean valid = true;
		while (valid) {
			System.out.println("Enter new amount for checking account");
			if (scan.hasNextDouble()) {
				double cash = scan.nextDouble();
				c.getBankAccount().setCashAccount(cash);
				valid = false;
			} else {
				System.out.println("Must be a number");
			}
		}
		updateFiles(c);
	}

	private static void editCreditAccount(Customer c) {
		boolean valid = true;
		while (valid) {
			System.out.println("Enter new amount for credit account");
			if (scan.hasNextDouble()) {
				double cash = scan.nextDouble();
				c.getBankAccount().setCreditAccount(cash);
				valid = false;
			} else {
				System.out.println("Must be a number");
			}
		}
		updateFiles(c);
	}

	private static void editSavingAccount(Customer c) {
		boolean valid = true;
		while (valid) {
			System.out.println("Enter new amount for saving account");
			if (scan.hasNextDouble()) {
				double cash = scan.nextDouble();
				c.getBankAccount().setSavingAccount(cash);
				valid = false;
			} else {
				System.out.println("Must be a number");
			}
		}
		updateFiles(c);
	}

	private static void printCustomerEdit() {

		System.out.println("(6)Edit Checking Account");
		System.out.println("(7)Edit Saving Account");
		System.out.println("(8)Edit Credit Account");
		System.out.println("(9)Back to menu");
	}

	private static void printUserEdit() {
		System.out.println("(1)Edit First Name");
		System.out.println("(2)Edit Last Name");
		System.out.println("(3)Edit Password");
		System.out.println("(4)Edit Email");
		System.out.println("(5)Edit Username");
	}

	private static void printEmployeeEdit() {
		System.out.println("(6)Edit Employee's Client List");
		System.out.println("(7)Back");
	}
}
