package com.WilliamLewis.BankingApp.Users;

/**
 * Similar implementation to admin and employee, note that customers do not hold account info directly, only the ID
 * use ID to access BankData and retrieve account
 */
import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

public class Customer implements Serializable{
	private String Username;
	private String password;
	private ArrayList<Integer> accountIdsToManage;
	private static Logger log = Logger.getRootLogger();
	private static final long serialVersionUID = 1234578L;
//Methods; apply for account
//
	public Customer()
	{
		
	}
	public Customer(String username){
		this.setUsername(username);
		this.setPassword("");
		this.accountIdsToManage = new ArrayList<Integer>();
		BankData.getInstance().addCustomer(this);
	}
	public Customer(String username, String pass){
		this.setUsername(username);
		this.setPassword(pass);
		this.accountIdsToManage = new ArrayList<Integer>();
		log.info("New Customer added: " + this.toString());
		BankData.getInstance().addCustomer(this);
	}
	public void addAccountID(int i)
	{
		accountIdsToManage.add(i);
	}
	
	public void submitApplication(){
		log.trace(this.Username + " has submitted an application for a basic account");
		BankData.getInstance().addApp(new AccountApplication(this, "basic"));
	}
	public void submitApplication(String type){
		log.trace(this.Username + " has submitted an application for a basic account");
		BankData.getInstance().addApp(new AccountApplication(this, type));
	}
	public String getUsername() {
		return Username;
	}
	private void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Account> copyOfAccountList()
	{
		ArrayList<Account> myAccs = new ArrayList<Account>();
		for(Integer key : this.accountIdsToManage)
		{
			myAccs.add(BankData.getInstance().getAccount(key));
		}
		return myAccs;
	}
}
