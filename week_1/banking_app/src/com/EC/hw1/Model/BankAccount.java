package com.EC.hw1.Model;

import java.util.Date;

public class BankAccount extends Account {

	private double cashAccount;
	private double savingAccount;
	private double creditAccount;

	public BankAccount() {
		super();
	}

	public BankAccount(String email, String password, Date lastLogin, double cashAccount, double savingAccount,
			double creditAccount) {
		super(email, password, lastLogin);
		setCashAccount(cashAccount);
		setSavingAccount(savingAccount);
		setCreditAccount(creditAccount);
	}

	public double getCashAccount() {
		return cashAccount;
	}

	public void setCashAccount(double cashAccount) {
		this.cashAccount = cashAccount;
	}

	public double getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(double savingAccount) {
		this.savingAccount = savingAccount;
	}

	public double getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(double creditAccount) {
		this.creditAccount = creditAccount;
	}
	
	
}
