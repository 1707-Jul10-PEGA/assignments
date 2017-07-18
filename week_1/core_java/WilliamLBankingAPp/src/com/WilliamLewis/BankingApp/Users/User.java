package com.WilliamLewis.BankingApp.Users;

import java.util.List;

import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
/**
 * This implementation makes no use of User, but it's on the refactoring list to make a general user that
 * each specific type of user extends, should help clean up a lot of redundent code, and simplify logic for GUI.
 * @author William
 *Some things to note about all three implemented users
 *All of them add themselves to the BankData upon creation
 *All of them have a means to access accounts, Customer and Employee hold accountIDs to access acounts relevent to them
 *
 */
public abstract class User {
	public String Username;
	private String password;
	
	public User(){
		
	}
	public User(String username, String password)
	{
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
	}

}
