package com.cg.bankingapp;

import java.io.Serializable;

public class CheckingsAccount extends Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3079936417772L;
	// Variables
	private double balance;

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
}
