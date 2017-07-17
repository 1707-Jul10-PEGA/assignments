package com.rb.driver;


import com.rb.users.Admin;
import com.rb.users.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import static com.rb.driver.Driver.SCAN;

public final class Bank implements Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = -7287576941330520886L;

    private final HashMap<String, User> USER_MAP 
	    = new HashMap<String, User>();
	
	private static int NEXT_USER_ID = 0;
	
	private static int NEXT_ACCOUNT_ID = 0;
	
	static Bank getBank(){
	    
	    String fileLocation = "src\\main\\resources\\bankOutput.txt";
	    Bank bank = null;
	    
	    try{
	        
	        FileInputStream fileIn = new FileInputStream(fileLocation);
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        bank = (Bank) in.readObject();
	        in.close();
	        fileIn.close();
	        return bank;
	    }catch(IOException e){
	        // TODO error logging, file not found
	        bank = new Bank();
	        return bank;
	    }catch(ClassNotFoundException e){
	        //TODO error logging
	        bank = new Bank();
	        return bank;
	        
	    }
	    
	}
	
	
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
			} else if (this.getUserFromMap(name) != null) {
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
	
	
	private String readString(){
		String input = null;
		
		try{
			input = SCAN.nextLine();
		}catch (Exception e){
			// TODO logging
		}
		
		return input;
	}
	
	public User getUserFromMap(String name){
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
	
	public ArrayList<User> getAllUsers(int userType){
	    ArrayList<User> userGroup = new ArrayList<User>();
	    
	    USER_MAP.forEach((k,v) -> {
	        if(v.getAccess() == userType){
	            userGroup.add(v);
	        }
	    });
	    
	    return userGroup;
	}
	
}
