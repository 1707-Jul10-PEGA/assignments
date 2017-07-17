package com.rb.driver;


import com.rb.users.Admin;
import com.rb.users.User;

import java.util.ArrayList;
import java.util.HashMap;
import static com.rb.driver.Driver.SCAN;

public final class Bank {
	
	
	private static Bank bank;
	
	private static boolean created = false;
	
	private static final HashMap<String, User> USER_MAP 
	    = new HashMap<String, User>();
	
	private static int NEXT_USER_ID = 0;
	
	private static int NEXT_ACCOUNT_ID = 0;
	
	
	private Bank() {
		String name;
		String pass1;
		String pass2;
		
		boolean badName = true;
		boolean badPass = true;
		
		System.out.println("New system: please setup admin account.");
		
		do{
			System.out.print("Please enter a username: ");
			
			name = readString();
			
			if (name == null) {
				System.out.println("Invalid input, "
					+ "please try again.");
			} else if (Bank.getUserFromMap(name) != null) {
				System.out.println(name + " is unavailable. "
					+ "Please try again.");
			} else {
				badName = false;
			}
			
		} while (badName);
		
		do{
			
			System.out.print("Please enter a password: ");
			
			pass1 = readString();
			
			System.out.print("Please confirm your password: ");
			
			pass2 = readString();
			
			if (pass1 == null || pass2 == null) {
				System.out.println("Invalid input, "
					+ "please try again.");
			} else if (pass1.equals(pass2)) {
				badPass = false;
			} else {
				System.out.println("Password inputs do not match. "
					+ "Please try again.");
			}
			
		} while (badPass);
		
		Admin firstUser = new Admin(name, pass1);
		addUser(firstUser);
	}
	
	public synchronized static Bank getBank() {
		if (created) {
			return bank;
		} else {
			bank = new Bank();
			created = true;
			return bank;
		}
	}
	
	private String readString(){
		String input = null;
		
		try{
			input = SCAN.nextLine();
		}catch (Exception e){
			// TODO logging
		}
		
		return input;
	}
	
	public static User getUserFromMap(String name){
		return USER_MAP.get(name);
	}
	
	public void addUser(User toAdd){
		USER_MAP.put(toAdd.getName(), toAdd);
	}
	
	public static int getNEXT_USER_ID() {
		NEXT_USER_ID++;
		return NEXT_USER_ID;
	}
	
	public static int getNEXT_ACCOUNT_ID() {
		NEXT_ACCOUNT_ID++;
		return NEXT_ACCOUNT_ID;
	}
	
	public static ArrayList<User> getAllUsers(int userType){
	    ArrayList<User> userGroup = new ArrayList<User>();
	    
	    USER_MAP.forEach((k,v) -> {
	        if(v.getAccess() == userType){
	            userGroup.add(v);
	        }
	    });
	    
	    return userGroup;
	}
	
}
