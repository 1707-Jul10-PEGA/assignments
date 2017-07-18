package com.WilliamLewis.BankingApp.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.AccountFactory.AccountFactory;
import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
/*
 * Class to represent admin users, have only an associated username and password, GUI takes care of assuring 
 * an admin is logging in.
 * Refer to the USer.java class for some details on admin/employee/customer
 */
public class Admin implements Serializable{
	public String Username;
	private String password;
	private static Logger log = Logger.getRootLogger();
	private static final long serialVersionUID = 12345L;
	//Unused constructor
	public Admin() {

	}
	//Used constructor, note addition to the BankData, all users do this
	public Admin(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		BankData.getInstance().addAdmin(this);
	}

	/**
	 * Used by the GUI to set up list of Accounts to manage, also useful for info call
	 * @return
	 */
	public ArrayList<Account> seeAllAccounts() {
		ArrayList<Account> allAccounts = BankData.getInstance().getAccountList();
		log.info(allAccounts.toString());

		return allAccounts;
	}
	/**
	 * Works as it does in BankData, redundancy is for sake of the GUI
	 * @param aa
	 */
	public void approveApplication(AccountApplication aa)
	{
		//Call factory and create account, store that integer in the arraylist of acounts to manage
		Integer id = AccountFactory.createAccount(aa.getAccountType(), aa.getAccountHolder().getUsername());
		BankData.getInstance().removeApp(aa);
		
	}
	/**
	 * FOR GUI, redundant with BankData Method
	 * @param aa
	 */
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
