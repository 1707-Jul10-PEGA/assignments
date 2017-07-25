package com.bank.customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bank.factory.BankAccount;
import com.bank.user.User;

public class Customer extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2347962411094264686L;
	
	private List<String> accountsToProcess = new ArrayList<String>();
	private List<BankAccount> accountList = new ArrayList<BankAccount>();
	
	
	public Customer(int db_id, String getfName, String getlName, String getuName, String pass, String position) {
		// TODO Auto-generated constructor stub
		this.setdbID(db_id);
		this.setfName(getfName);
		this.setlName(getlName);
		this.setuName(getuName);
		this.setPass(pass);
		this.setPosition(position);
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<BankAccount> getAccountList() {
		return accountList;
	}
	public void appendAccountList(BankAccount newC) {
		this.accountList.add(newC);
	}
	public List<String> getAccountsToProcess() {
		return accountsToProcess;
	}
	
	public void requestAccount(String type){
		switch(type.toLowerCase()){
		case "checking" :
			String toGoC = LocalDateTime.now() + " ::  Checking";
			getAccountsToProcess().add(toGoC);
		break;
		case "savings" :
			String toGoS = LocalDateTime.now() + " :: Savings";
			getAccountsToProcess().add(toGoS);
		break;
		default:
			System.out.println("error");
		}
		System.out.println("Number of accounts in processing: " + this.getAccountsToProcess().size() + "\n ");
		for(int x = 0; x < this.getAccountsToProcess().size(); x++){
			System.out.println( this.getAccountsToProcess().get(x).toString());
		}
	}
}
