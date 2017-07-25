package com.rb.users;

import static com.rb.driver.Driver.SCAN;
//import static com.rb.driver.Driver.BANK_SYSTEM;
//import static com.rb.driver.Driver.LOG;
import static com.rb.driver.Driver.USER_DAO;

import java.sql.SQLException;

public class LoginMenu {
	
	public static User logIn(){
		
	    User loggingIn = null;
	    
	    do{
    		System.out.print("Enter your username: ");
    		String name = SCAN.nextLine();
    		
    		System.out.print("Enter your password: ");
    		String pass = SCAN.nextLine();
    		
    		try {
                loggingIn = USER_DAO.login(name, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    		
    		if (loggingIn == null){
    		    System.out.println("Incorrect username or password.");
                System.out.println("Please try again.\n");
    		}
    		
	    } while (loggingIn == null);
	    
	    return loggingIn;
	}
}
