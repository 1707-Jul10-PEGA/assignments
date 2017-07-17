package com.WilliamLewis.BankingApp.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

public class Admin implements Serializable{
	public String Username;
	private String password;
	private static Logger log = Logger.getRootLogger();
	private static final long serialVersionUID = 12345L;
	public Admin() {

	}

	public Admin(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		BankData.getInstance().addAdmin(this);
	}

	public ArrayList<Account> seeAllAccounts() {
		ArrayList<Account> allAccounts = BankData.getInstance().getAccountList();
		log.info(allAccounts.toString());

		return allAccounts;
	}

	private String getUsername() {
		return Username;
	}

	private void setUsername(String username) {
		Username = username;
	}

	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}
}
