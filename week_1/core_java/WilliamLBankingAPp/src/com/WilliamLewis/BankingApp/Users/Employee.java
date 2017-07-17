package com.WilliamLewis.BankingApp.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.AccountFactory.AccountFactory;
import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

public class Employee implements Serializable{
	public String Username;
	private String password;
	private static Logger log = Logger.getRootLogger();
	private ArrayList<AccountApplication> pendingApplications;
	private ArrayList<Integer> accountIdsToManage;
	private static final long serialVersionUID = 54321L;
	
	public Employee()
	{
		this.Username = "Improper Method Call";
		this.password = "";
		pendingApplications = new ArrayList<AccountApplication>();
		accountIdsToManage = new ArrayList<Integer>();
		BankData.getInstance().addEmployee(this);
	}
	public Employee(String name, String password)
	{
		this.setUsername(name);
		this.setPassword(password);
		pendingApplications = new ArrayList<AccountApplication>();
		accountIdsToManage = new ArrayList<Integer>();
		BankData.getInstance().addEmployee(this);
		
	}

	public void approveApplication(AccountApplication aa)
	{
		//Call factory and create account, store that integer in the arraylist of acounts to manage
		Integer id = AccountFactory.createAccount(aa.getAccountType(), aa.getAccountHolder());
		accountIdsToManage.add(id);
		BankData.getInstance().removeApp(aa);
		
	}
	public void approveAll()
	{
		for(AccountApplication aa : this.pendingApplications)
		{
			approveApplication(aa);
		}
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
	public boolean addApplication(AccountApplication aa)
	{
		this.pendingApplications.add(aa);
		return true;
	}
	private String getUsername() {
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
	public ArrayList<AccountApplication> getPendingApplications() {
		return pendingApplications;
	}
	private void setPendingApplications(ArrayList<AccountApplication> pendingApplications) {
		this.pendingApplications = pendingApplications;
	}
	
	
	
}
