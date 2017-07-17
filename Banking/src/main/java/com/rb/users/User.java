package com.rb.users;

import com.rb.driver.Bank;

public abstract class User {
	
	private String name;
	
	private String password;
	
	private int access;
	
	private int userID;	
	
	
	User(int access, String name, String password){
		Bank bank = Bank.getBank();
		
		this.userID = Bank.getNEXT_USER_ID();
		
		this.name = name;
		this.password = password;
		this.access = access;
		
		bank.addUser(this);
	}

	public String getName() {
		return name;
	}


	public String getPassword() {
		return password;
	}


	public int getAccess() {
		return access;
	}


	public int getUserID() {
		return userID;
	}
	
	public String toString(){
	    
	    return "User: " + name + "  Access level: " + access + "  User ID: " 
	            + userID;
	    
	}
	
}
