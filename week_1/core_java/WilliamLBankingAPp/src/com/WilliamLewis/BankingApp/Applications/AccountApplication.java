package com.WilliamLewis.BankingApp.Applications;

import java.io.Serializable;

public class AccountApplication implements Serializable {
	private String accountType;
	private String accountHolder;
	private static final long serialVersionUID = 12321535234345L;

	public AccountApplication()
	{
		
	}
	public AccountApplication(String user, String type)
	{
		this.setAccountHolder(user);
		this.setAccountType(type);
	}
	public String getAccountType() {
		return accountType;
	}
	private void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	private void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
}
