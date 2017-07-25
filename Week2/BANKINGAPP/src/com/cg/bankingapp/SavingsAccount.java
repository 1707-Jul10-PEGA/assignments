package com.cg.bankingapp;

import java.io.Serializable;

public class SavingsAccount extends Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3882423132976067394L;
	//Variables
	private double interestPercent;
	private double balance;
	private int accountNumber;
	
	public SavingsAccount(double balance) {
		super("savings");
		this.balance = balance;
	}
	
	public SavingsAccount(int accountid, double balance) {
		super("savings");
		this.balance = balance;
		this.accountNumber = accountid;
	}

	

	/*
	 * Subtract the amount from balance. Return 1 if successful. Return 0 if amount
	 * is less than or equal 0. Returns -1 if amount is higher than the available
	 * balance
	 */
	public int withdraw(Double money) {
		if (money > 0 && money < this.balance) {
			this.balance -= money;
			return 1;
		} else {
			if (money > this.balance) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	/*
	 * Add amount to balance. Return 1 if successful. Return 0 if amount is less
	 * than or equal 0.
	 */
	public int deposit(Double money) {
		if (money > 0) {
			this.balance += money;
			return 1;
		} else {
			return 0;
		}
	}

	// Getters
	public double getBalance() {
		return balance;
	}

	protected void setBalance(Double newBalance) {
		this.balance = newBalance;
	}

	public void addInterest() {
		double newBalance = getBalance() * (interestPercent/100);
		setBalance(newBalance);
	}
	
	//Getters and Setters
	public double getInterestPercent() {
		return interestPercent;
	}

	public void setInterestPercent(double interestPercent) {
		this.interestPercent = interestPercent;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
}
