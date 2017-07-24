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
public class Admin extends User implements Serializable{
	private static Logger log = Logger.getRootLogger();
	private static final long serialVersionUID = 12345L;
	//Unused constructor
	public Admin() {
		super();
	}
	public Admin(Integer userID, String username, String password, String firstName, String lastName)
	{
		super(userID, username, password, firstName, lastName);
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
	public void approveApplication(Account acc)
	{
		//Call factory and create account, store that integer in the arraylist of acounts to manage
		BankData.getInstance().approveApplication(acc);
		
	}
	/**
	 * FOR GUI, redundant with BankData Method
	 * @param aa
	 */
	public void removeApplication(Account aa)
	{
		BankData.getInstance().removeApp(aa);
	}
	public ArrayList<Account> viewApplications()
	{
		return BankData.getInstance().getCurrentApplicationAccounts();
	}

}
