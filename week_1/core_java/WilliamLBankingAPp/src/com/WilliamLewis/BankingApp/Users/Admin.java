package com.WilliamLewis.BankingApp.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.AccountFactory.AccountFactory;
import com.WilliamLewis.BankingApp.Applications.AccountApplication;
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
	public void approveApplication(AccountApplication aa)
	{
		//Call factory and create account, store that integer in the arraylist of acounts to manage
		Integer id = AccountFactory.createAccount(aa.getAccountType(), aa.getAccountHolder().getUsername());
		BankData.getInstance().removeApp(aa);
		
	}
	public void removeApplication(AccountApplication aa)
	{
		BankData.getInstance().removeApp(aa);
	}
	public ArrayList<AccountApplication> viewApplications()
	{
		return BankData.getInstance().getCurrentApplications();
	}
	public void approveAllApplications()
	{
		for(AccountApplication aa : BankData.getInstance().getCurrentApplications())
		{
			approveApplication(aa);
		}
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
