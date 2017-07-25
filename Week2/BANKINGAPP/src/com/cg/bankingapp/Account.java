package com.cg.bankingapp;

public abstract class Account{
	private String accountType;
	
	public Account(String accountType) {
		this.setAccountType(accountType); 
	}
	public abstract int withdraw(Double money);
	public abstract int deposit(Double money);
	public abstract double getBalance();
	protected abstract void setBalance(Double newBalance);
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
