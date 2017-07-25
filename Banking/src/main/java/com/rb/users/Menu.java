package com.rb.users;

import static com.rb.driver.Driver.SCAN;
//import static com.rb.driver.Driver.BANK_SYSTEM;
import static com.rb.driver.Driver.USER_DAO;

import java.sql.SQLException;

import static com.rb.driver.Driver.ACCOUNT_DAO;

public abstract class Menu {
	
	protected static int readInput(){
		
		int input = -1;
		
		try {
			input = SCAN.nextInt();
		} catch (Exception e) {
			// TODO logging
		}finally{
			SCAN.nextLine();
		}
		
		return input;
	}
	
	
	protected static double readAmount(){
		
		double input = -1.0;
		
		try {
			input = SCAN.nextDouble();
		} catch (Exception e) {
			// TODO logging
		}finally{
			SCAN.nextLine();
		}
		
		return input;
	}
	
	protected static String readString(){
		String input = null;
		
		try{
			input = SCAN.nextLine();
		}catch (Exception e){
			// TODO logging
		}
		
		return input;
		
	}
	
	protected static String readUsername(){
	    
	    String name = null;
	    boolean badName = true;
	    
	    do {
            System.out.print("Please enter a username: ");

            name = readString();
            
            if (name == null) {
                System.out.println(
                        "Invalid input, " + "please try again.");
            } else
                try {
                    if (USER_DAO.usernameOpen(name)) {
                        System.out.println(
                                name + " is unavailable. Please try again.");
                    } else {
                        badName = false;
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    
                    System.out.println("An error occurred, please try again.");
                }

        } while (badName);
	    
	    return name;
	}
	
	protected static String readPassword(){
	    
	    String pass1 = null;
	    String pass2 = null;
	    boolean badPass = true;
	    
	    do {

            System.out.print("Please enter a password: ");

            pass1 = readString();

            System.out.print("Please confirm your password: ");

            pass2 = readString();

            if (pass1 == null || pass2 == null) {
                System.out.println(
                        "Invalid input, " + "please try again.");
            } else if (pass1.equals(pass2)) {
                badPass = false;
            } else {
                System.out.println(
                        "Password inputs do not match. Please try again.");
            }

        } while (badPass);
	    
	    return pass1;
	}
	
}
