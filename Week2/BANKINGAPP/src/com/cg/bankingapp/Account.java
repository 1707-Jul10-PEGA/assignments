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
	public int getAccountType() {
		if("checkings".equals(accountType)) {
			return 1;
		}else{
			return 2;
		}
		
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
