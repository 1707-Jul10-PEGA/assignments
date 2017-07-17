package com.as.bankingapp.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.as.bankingapp.commandparser.CommandParser;
import com.as.bankingapp.filemanager.FileManager;
import com.as.bankingapp.inputchecker.InputChecker;
import com.as.bankingapp.login.Login;
import com.as.bankingapp.user.User;

public class Driver {
	
	private static Logger transactionLogger = Logger.getLogger("transactionLogger");
	
	public static void main(String[] args) {
		String userFilename = "Users.txt";
		
		//String accountsFilename = "Accounts.txt";
		 
		boolean exiting = false;

		transactionLogger.info("Starting Banking App.");
		//Populate
		//Populate.populate();
		
		//list containing all valid users
		List<User> userList = new ArrayList<User>();
		//list contain all active accounts
		//List<Account> accounts = new ArrayList<Account>();
		
		//open files and read in objects
		FileManager.readInUsers(userFilename, userList);
		//FileManager.readInAccounts(accountsFilename, accounts);

		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to 1707PEGA Bank.");
		do {		
			
			//login
			User currentUser = null;
			boolean loggingOut = false;
			
			do {
				System.out.print("Please enter your username: ");
				String username = s.nextLine();
				if (InputChecker.isValidUserName(username)) {
					System.out.print("Please enter your password: ");
					String password = s.nextLine();
					currentUser = Login.login(username, password, userList);
				}
			} while (currentUser == null);
			
			//logging set currentUser has logged in---------------------------------------------
			transactionLogger.info(currentUser.getUserName() + " has logged in.");
			
			System.out.println("Welcome " + currentUser.getUserName());
			
			//inner loop for user actions
			do {
				//get a command
				String command;
				boolean valid = true;
				do {
					System.out.print("What would you like to do? ");
					command = s.nextLine();
					valid = InputChecker.isValidCommand(command, currentUser);
					if (!valid) {
						System.out.println("Invalid command.");
					}
				} while (!valid);
				//has a valid command
				//now execute it
				if ("exit".equals(command)) {
					exiting = true;
					loggingOut = true;
				} else if ("loggout".equals(command)) {
					loggingOut = true;
				} else {
					CommandParser.parseCommand(command, currentUser, userList);
				}
			} while (!loggingOut);
			//logging set currentUser has logged out---------------------------------------------
			transactionLogger.info(currentUser.getUserName() + " has Logged out.");
		} while(!exiting);
		s.close();
		//store objects in file
		FileManager.writeOutUsers(userFilename, userList);
		//FileManager.writeOutAccounts(accountsFilename, accounts);
		System.out.println("We hope to see you again.");
		transactionLogger.info("Closing Banking App.");
	}
	
}
