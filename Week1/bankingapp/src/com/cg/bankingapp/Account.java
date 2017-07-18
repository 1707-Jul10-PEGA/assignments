package com.cg.bankingapp;

public abstract class Account{

	public abstract int withdraw(Double money);
	public abstract int deposit(Double money);
	public abstract double getBalance();
	protected abstract void setBalance(Double newBalance);
}
