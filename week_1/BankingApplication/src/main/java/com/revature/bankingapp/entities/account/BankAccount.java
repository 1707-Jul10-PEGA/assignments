package com.revature.bankingapp.entities.account;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.interfaces.BankAccountInterface;

public class BankAccount implements BankAccountInterface, Serializable {

	private UUID accountId;
	private double balance;
	private String dateOpened;
	private UUID ownerId;
	private String status;
	private static final long serialVersionUID = 4655748803545285103L;
	
	public BankAccount() {}

	public BankAccount(UUID ownerId) {
		super();
		this.accountId = UUID.randomUUID();
		this.balance = 0;
		this.dateOpened = LocalTime.now().toString();
		this.ownerId = ownerId;
		this.status = "pending";
	}
	
	public boolean activateAccount() {
		this.status = "active";
		return true;
	}
	
	public String getStatus() {
		
		if(this.status.equals("pending")) {
			return "Application under review by bank associate";
		}
		
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean withdraw(double ammount) {
		// TODO Auto-generated method stub
		
		if(this.getStatus().equals("pending")) {
			System.out.println("We are sorry, you cannot withdraw at this time."
					+ " This account is under application review. Thank you for your patience");
			return false;
		}
		
		if(this.balance < ammount) {
			System.out.println("Not enough funds\n");
			return false;
		}
		else
			this.balance -= ammount;
		
		System.out.println("Withdrwa succesfull. New Balance is: " + this.getBalance());
		return true;
		
	}

	@Override
	public boolean deposit(double ammount) {
		
		if(this.getStatus().equals("pending")) {
			System.out.println("We are sorry, you cannot deposit at this time."
					+ " This account is under application review. Thank you for your patience");
			return false;
		}
		else if(this.getStatus().equals("active")){
		// TODO Auto-generated method stub
		this.balance += ammount;
		System.out.println("Deposit successful. New Balance is: " + this.getBalance());
		return true;
		}
		return false;
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
		return "Account Id= " + accountId 
				+ "\nBalance= " + balance 
				+ "\nDate Opened= " + dateOpened
				+ "\nOwner Id= " + ownerId
				+ "\nStatus= " + getStatus();
	}

	@Override
	public boolean viewBalance() {
		// TODO Auto-generated method stub
		this.toString();
		return true;
	}


	
}
