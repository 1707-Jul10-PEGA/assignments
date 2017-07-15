package com.EC.hw1.Model;

public class BankAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8180240208218125726L;
	private double cashAccount;
	private double savingAccount;
	private double creditAccount;

	public BankAccount() {
		super();
	}

	public BankAccount(String email, double cashAccount, double savingAccount, double creditAccount) {
		super(email);
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
