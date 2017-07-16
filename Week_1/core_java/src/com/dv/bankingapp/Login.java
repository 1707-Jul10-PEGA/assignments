package com.dv.bankingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login implements LoginInterface {

	// having one scanner; issues when closing and reopening a scanner
	static final Scanner read = new Scanner(System.in);
	
	// loads list from file and adds to it per user
	static List<User> userList = new ArrayList<User>();
	
	// one serializable object that reads and writes to users.txt
	static SerializeUser serialUser = new SerializeUser();

	@Override
	public void printCodes() {
		System.out.println("Enter one of the codes below, or any other number to exit: ");
		System.out.println("0: Login");
		System.out.println("1: Create customer account");
		System.out.println("2: Create employee account");
		System.out.println("3: Create admin account\n");
	}

	@Override
	public int promptWelcome() {
		int code = 0;
	
		System.out.println("===== Welcome =====\n");
		printCodes();

		// ensure user enters an integer 
		try {
			code = Integer.parseInt(read.nextLine());
			return code;
		}
		
		catch (NumberFormatException e) {
			System.out.println("Input entered was not a number. Exiting ...");
		}
		
		return -1;
	}

	@Override
	public String removeSpaces(String userName) {
		String newUserName = userName;
	
		while(newUserName.contains(" ")) {
			System.out.println("\nUsername cannot contain spaces.");
			System.out.print("Enter username: ");
			newUserName = read.nextLine();
		}
		
		return newUserName;
		
	}
	
	@Override
	public boolean userExists(String userName) {
		for(User u : userList) {
			if(userName.equals(u.getUserName())) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public boolean isPasswordCorrect(User user, String pw) {
		if(user.getPw().equals(pw)) {
			return true;
		}

		return false;
	}

	@Override
	public int promptLogin() {
		String userName = "", pw = "";
		User user = null;

		System.out.println("\n===== Login =====\n");
		System.out.print("Username: ");
		userName = read.nextLine();
		userName = removeSpaces(userName);
		
		// if user exists, check for verification
		if(userExists(userName)) {
		
			// match correct user
			for(User u : userList) {
				if(userName.equals(u.getUserName())) {
					user = u;
				}
			}
		
			System.out.print("Password: ");
			pw = read.nextLine();
			
			if(isPasswordCorrect(user, pw)) {
				return 1;
			}
			
			else {
				System.out.println("Wrong password!");
				return 0;
			}
		}
		
		else {
			System.out.println("Username " + userName + " does not exist!");
			return 0;
		}

	}
	
	@Override
	public void saveUser(User user, String userName, String pw) {
		user.setUserName(userName);
		user.setPw(pw);
		userList.add(user);
		serialUser.writeUserList(userList);
		
		System.out.println("\nCustomer " + userName + " successfully created.");
	
	}

	@Override
	public int createCustomer() {
		String userName, pw;
		User newCustomer = new Customer();
		
		System.out.println("\n===== Create new customer account =====\n");
		System.out.print("Enter username: ");
		userName = read.nextLine();
		userName = removeSpaces(userName);

		// if user is not taken, create an account
		if(!(userExists(userName))) {
			System.out.print("Enter password: ");
			pw = read.nextLine();

			// save customer to file
			saveUser(newCustomer, userName, pw);
			System.out.println(serialUser.readUserList());
			
			return 1;
		
		}
		
		else {
			System.out.println("User " + userName + " already exists!");
			return 0;
		}
		
	}

	@Override
	public int createEmployee() {
		String userName, pw;
		User newEmployee = new Employee();
		
		System.out.println("\n===== Create new emplpoyee account =====\n");
		System.out.print("Enter username: ");
		userName = read.nextLine();
		userName = removeSpaces(userName);

		// if user is not taken, create an account
		if(!(userExists(userName))) {
			System.out.print("Enter password: ");
			pw = read.nextLine();
			
			// save employee to file
			saveUser(newEmployee, userName, pw);
			System.out.println(serialUser.readUserList());
			
			return 1;
		}
		
		else {
			System.out.println("User " + userName + " already exists!");
			return 0;
		}

	}

	@Override
	public int createAdmin() {
		String userName, pw;
		User newAdmin = new Admin();
		
		System.out.println("\n===== Create new admin account =====\n");
		System.out.print("Enter username: ");
		userName = read.nextLine();
		userName = removeSpaces(userName);

		// if user is not taken, create an account
		if(!(userExists(userName))) {
			System.out.print("Enter password: ");
			pw = read.nextLine();
			
			// save admin to file
			saveUser(newAdmin, userName, pw);
			System.out.println(serialUser.readUserList());
			
			return 1;
		}
		
		else {
			System.out.println("User " + userName + " already exists!");
			return 0;
		}
		
	}

	@Override
	public int prompt() {
		int code = 0;
		int verified = 0;
	
		// load in the user list from users.txt
		userList = serialUser.readUserList();
	
		code = promptWelcome();
		switch(code) {
			case 0:
				verified = promptLogin();
				break;
			case 1:
				verified = createCustomer();
				break;
			case 2:
				verified = createEmployee();
				break;
			case 3:
				verified = createAdmin();
				break;
			default:
				break;
		}

		read.close();
		return verified;
	}

}