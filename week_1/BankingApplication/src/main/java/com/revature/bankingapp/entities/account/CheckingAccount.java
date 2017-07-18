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
	public CheckingAccount(UUID ownerId) {
		super(ownerId);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account type: Checking \n" + super.toString();
	}
	
	
	
	
	

}
