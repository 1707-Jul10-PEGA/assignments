package com.rb.users;

import static com.rb.driver.Driver.SCAN;
import static com.rb.driver.Driver.BANK_SYSTEM;
import static com.rb.driver.Driver.LOG;

public class LoginMenu {
	
	public static User logIn(){
		
		System.out.print("Enter your username: ");
		String name = SCAN.nextLine();
		
		System.out.print("Enter your password: ");
		String pass = SCAN.nextLine();
		
		User loggingIn = BANK_SYSTEM.theBank.getUserFromMap(name);
		
		if (loggingIn == null){
		    System.out.println("Incorrect username or password.");
            System.out.println("Please try again.\n");
            return null;
		} else if (pass.equals(loggingIn.getPassword())) {
		    
		    LOG.trace(loggingIn.getName() + " logged in");
		    
			System.out.println("Welcome.");
			return loggingIn;
		}else{
			System.out.println("Incorrect username or password.");
			System.out.println("Please try again.\n");
			return null;
		}
	}
	
}
