package com.revature.bankingapp.entities.account;

import java.util.UUID;

import com.revature.bankingapp.interfaces.BankAccountInterface;

public class SavingsAccount extends BankAccount implements BankAccountInterface{
	
	private double interestRate = 4.3;

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public SavingsAccount(UUID ownerId) {
		super(ownerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account type: Savings \n" + super.toString();
	}
	
	
	
	
}
