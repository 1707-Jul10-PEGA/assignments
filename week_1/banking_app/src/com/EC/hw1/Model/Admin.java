package com.EC.hw1.Model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.EC.hw1.Interfaces.AdminInterface;
import com.EC.hw1.Utilities.BankUtilities;

public class Admin extends User implements AdminInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7689680374583441970L;
	private static Logger log = Logger.getRootLogger();
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
		Collections.sort(userList,Collections.reverseOrder());
		
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
		
		boolean valid = true;

		while (valid) {
			System.out.println("Account username you would to edit:");
			String username = scan.next();
			User user = BankUtilities.readUser(username);
			if (user != null && user instanceof Customer) {
				while (valid) {
					System.out.println("Please enter a number between 1-10 to continue");
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
							((Customer) user).viewBalance();
							break;
						case 10:
							valid = false;
							break;
						}
					} else{
						scan.next();
					}
				}

			} else if (user != null && user instanceof Employee) {
				while (valid) {
					System.out.println("Please enter a number between 1-9 to continue");
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
							approveEmployeesApp((Employee) user);
							break;
						case 8:
							viewEmployeesClientList((Employee) user);
							break;
						case 9:
							valid = false;
							break;
						}
					}else{
						scan.next();
					} 
				}
			}else if(user != null && user instanceof Admin){
				System.out.println("You cannot edit another Admin's account");
			}
		}

	}

	private void viewEmployeesClientList(Employee user) {
		user.viewCustomerList();
		
	}

	private void approveEmployeesApp(Employee user) {
		user.checkApplications();
		
	}

	private void editEmployeesClients(Employee e) {
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
					break;
				case 3:
					e.viewCustomerList();
					break;
				case 4:
					valid = true;
					break;
				}
			}else{
				//clear invalid input
				scan.next();
			}
		}

	}

	private void removeClient(Employee e) {
		System.out.println("Please enter the Client's username that you would like to remove");
		String username = scan.next();
		if(BankUtilities.accountExist(username)){
			Customer c = (Customer) BankUtilities.readUser(username);
			List<Customer> tmp = e.getCustList();
			if(tmp.contains(c)){
				tmp.remove(c);
				updateFiles(e);
				System.out.println("Successfully removed account: " + username + " from "+ e.getUserName()+ "'s clients list");
				log.trace("Successfully removed account: " + username + " from "+ e.getUserName()+ "'s clients list");
			}else{
				System.out.println("This client is not assigned to this employee");
			}
			
		}
		
	}

	private void addClient(Employee e) {
		System.out.println("Please enter the Customer's username that you would like to add");
		String username = scan.next();
		if(BankUtilities.accountExist(username)){
			Customer c = (Customer) BankUtilities.readUser(username);
			if(e.getCustList().contains(c)){
				System.out.println("This client is already assigned to this employee");
			}else{
				e.addCustomer(c);
				updateFiles(e);
				System.out.println("Successfully added account: " + username + " to "+ e.getUserName()+ "'s clients list");
				log.trace("Successfully added account: " + username + " to "+ e.getUserName()+ "'s clients list");
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

	private void updateFiles(User u) {
		if (u instanceof Employee) {
			BankUtilities.writeEmployee((Employee) u);
			BankUtilities.writeUser((Employee) u);
		} else {
			BankUtilities.writeUser((Customer) u);
		}
	}

	private void editFirstName(User u) {
		System.out.println("Enter new first name");
		u.setFirstName(scan.next());
		updateFiles(u);
		log.trace("Admin " + this.getUserName() + " changed " + u.getUserName() +"'s first name to " + u.getFirstName() );
	}

	private void editLastName(User u) {
		System.out.println("Enter new last name");
		u.setLastName(scan.next());
		updateFiles(u);
		log.trace("Admin " + this.getUserName() + " changed " + u.getUserName() +"'s last name to " + u.getLastName() );

	}

	private void editPassword(User u) {
		System.out.println("Enter new password");
		u.setPassword(scan.next());
		updateFiles(u);		
		log.trace("Admin " + this.getUserName() + " changed " + u.getUserName() +"'s password to " + u.getPassword());

	}

	private void editEmail(User u) {
		System.out.println("Enter new email address");
		String email = scan.next();
		if (u instanceof Customer) {
			((Customer) u).getBankAccount().setEmail(email);
			updateFiles(u);
		} else {
			((Employee) u).getAccount().setEmail(email);
			updateFiles(u);
		}
		log.trace("Admin " + this.getUserName() + " changed " + u.getUserName() +"'s email to " + email );


	}

	private void editUserName(User u) {
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
					
					Path path1 = Paths.get("Employees/"+oldUserName+".txt");
					BankUtilities.deleteUser(path1);
				}
				Path path2 = Paths.get("Users/"+oldUserName+".txt");
				BankUtilities.deleteUser(path2);
				log.trace("Admin " +this.getUserName() + " changed " + oldUserName +"'s username to " + u.getUserName());
				valid = false;
			}
		}
	}

	private void editCheckingAccount(Customer c) {
		boolean valid = true;
		while (valid) {
			System.out.println("Enter new amount for checking account");
			if (scan.hasNextDouble()) {
				double cash = scan.nextDouble();
				c.getBankAccount().setCashAccount(cash);
				log.trace("Admin " +this.getUserName() + " set " + c.getUserName() +"'s checking account" + c.getBankAccount().getCashAccount());
				valid = false;
			} else {
				System.out.println("Must be a number");
			}
		}
		updateFiles(c);
	}

	private void editCreditAccount(Customer c) {
		boolean valid = true;
		while (valid) {
			System.out.println("Enter new amount for credit account");
			if (scan.hasNextDouble()) {
				double cash = scan.nextDouble();
				c.getBankAccount().setCreditAccount(cash);
				log.trace("Admin " +this.getUserName() + " set " + c.getUserName() +"'s credit account" + c.getBankAccount().getCreditAccount());
				valid = false;
			} else {
				System.out.println("Must be a number");
			}
		}
		updateFiles(c);
	}

	private void editSavingAccount(Customer c) {
		boolean valid = true;
		while (valid) {
			System.out.println("Enter new amount for saving account");
			if (scan.hasNextDouble()) {
				double cash = scan.nextDouble();
				c.getBankAccount().setSavingAccount(cash);
				log.trace("Admin " +this.getUserName() + "set " + c.getUserName() +"'s saving account" + c.getBankAccount().getCashAccount());
				valid = false;
			} else {
				System.out.println("Must be a number");
			}
		}
		updateFiles(c);
	}

	private void printCustomerEdit() {

		System.out.println("(6)Edit Checking Account");
		System.out.println("(7)Edit Saving Account");
		System.out.println("(8)Edit Credit Account");
		System.out.println("(9)View Customer's Balance");
		System.out.println("(10)Back to menu");
	}

	private void printUserEdit() {
		System.out.println("(1)Edit First Name");
		System.out.println("(2)Edit Last Name");
		System.out.println("(3)Edit Password");
		System.out.println("(4)Edit Email");
		System.out.println("(5)Edit Username");
	}

	private void printEmployeeEdit() {
		System.out.println("(6)Edit Employee's Client List");
		System.out.println("(7)Back");
	}

	

	
}
