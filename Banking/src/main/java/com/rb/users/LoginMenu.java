package com.rb.users;

import static com.rb.driver.Driver.SCAN;
import static com.rb.driver.Driver.BANK_SYSTEM;

public class LoginMenu {
	
	public static User logIn(){
		
		System.out.print("Enter your username: ");
		String name = SCAN.nextLine();
		
		System.out.print("Enter your password: ");
		String pass = SCAN.nextLine();
		
		User loggingIn = BANK_SYSTEM.theBank.getUserFromMap(name);
		
		if (pass.equals(loggingIn.getPassword())) {
			System.out.println("Welcome.");
			return loggingIn;
		}else{
			System.out.println("Incorrect username or password.");
			System.out.println("Please try again.\n");
			return null;
		}
	}
	
}
