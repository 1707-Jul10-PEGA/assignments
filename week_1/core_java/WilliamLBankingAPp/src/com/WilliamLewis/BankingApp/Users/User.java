package com.WilliamLewis.BankingApp.Users;

import java.util.List;

import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

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
