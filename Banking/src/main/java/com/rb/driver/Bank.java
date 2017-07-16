package com.rb.driver;


import com.rb.users.Admin;
import com.rb.users.User;
import java.util.HashMap;

public final class Bank {
	
	
	private static Bank bank;
	
	private static boolean created = false;
	
	private static final HashMap<String, User> USER_MAP 
	    = new HashMap<String, User>();
	
	private static int NEXT_USER_ID = 0;
	
	private static int NEXT_ACCOUNT_ID = 0;
	
	
	private Bank() {
		Admin firstUser = new Admin();
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
}
