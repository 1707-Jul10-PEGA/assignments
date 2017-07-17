package com.as.bankingapp.customer;

import com.as.bankingapp.account.Account;
import com.as.bankingapp.user.User;

public class Customer extends User{
	
	private static final long serialVersionUID = -6614705024406425070L;

	private Account account;

	private boolean hasAccount;
	
	public Customer() {
		//this.setId("");
		super();
		this.setAccount(null);
		this.setHasAccount(false);
	}
	
	public Customer(String userName, String password) {
		super(userName, password);
		this.setAccount(null);
		this.setHasAccount(false);
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(boolean hasAccount) {
		this.hasAccount = hasAccount;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + (hasAccount ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}	
	
	
	
	
	
}
