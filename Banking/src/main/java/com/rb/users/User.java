package com.rb.users;

import com.rb.accounts.Account;
import com.rb.driver.Bank;
import static com.rb.driver.Driver.SCAN;

public abstract class User {
	
	private String name;
	
	private String password;
	
	private int access = 0;
	
	private int userID;
	
	Account activeAccount;
	
	
	
	public User(){
		userID = Bank.getNEXT_USER_ID();
		
		System.out.println();
		
	}
	
	public User(int access){
		this();
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
