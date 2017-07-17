package com.revature.bankingapp.entities.account;

import java.util.UUID;

import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.interfaces.BankAccountInterface;

public class BankAccount implements BankAccountInterface {

	private UUID accountId;
	private double balance;
	private String dateOpened;
	private UUID ownerId;
	private String status;
	
	public BankAccount() {
		
	}


	public BankAccount(UUID accountId, double balance, String dateOpened, UUID ownerId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.dateOpened = dateOpened;
		this.ownerId = ownerId;
		this.status = "pending";
	}
	


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public double viewBalance() {
		return this.balance;
	}

	@Override
	public boolean withdraw(double ammount) {
		// TODO Auto-generated method stub
		if(this.balance < ammount) {
			return false;
		}
		else
			this.balance -= ammount;
		
		return true;
		
	}

	@Override
	public boolean deposit(double ammount) {
		// TODO Auto-generated method stub
		this.balance += ammount;
		return true;
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(UUID accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}

	public UUID getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(UUID ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "Account Id=" + accountId 
				+ "\nBalance=" + balance 
				+ "\nDate Opened=" + dateOpened
				+ "\nOwner Id=" + ownerId ;
	}
	
	
	
	
}
