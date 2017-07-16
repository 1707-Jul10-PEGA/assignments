package com.rb.users;

import com.rb.accounts.Account;
import com.rb.driver.Bank;

public abstract class User {
	
	private String name;
	
	private String password;
	
	private int access = 0;
	
	private int userID;
	
	Account activeAccount;
	
	
	
	User(String name, String password){
		userID = Bank.getNEXT_USER_ID();
		
		this.name = name;
		this.password = password;
		
		System.out.println();
		
	}
	
	User(int access, String name, String password){
		this(name, password);
		this.access = access;
	}
	
	public Account getActiveAccount() {
		return activeAccount;
	}


	public void setActiveAccount(Account activeAccount) {
		this.activeAccount = activeAccount;
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
	
}
