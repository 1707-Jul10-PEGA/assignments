package com.revature.bankingapp.entities.account;

import java.util.UUID;

import com.revature.bankingapp.interfaces.BankAccountInterface;

public class CheckingAccount extends BankAccount implements BankAccountInterface{
	
	private double interestRate = 12.3;
	private double minimumBalanceAllowed = 200.00;
	
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getMinimumBalanceAllowed() {
		return minimumBalanceAllowed;
	}
	public void setMinimumBalanceAllowed(double minimumBalanceAllowed) {
		this.minimumBalanceAllowed = minimumBalanceAllowed;
	}
	public CheckingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckingAccount(UUID accountId, double balance, String dateOpened, UUID ownerId) {
		super(accountId, balance, dateOpened, ownerId);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
