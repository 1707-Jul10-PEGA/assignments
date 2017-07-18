package com.WilliamLewis.BankingApp.Applications;

import java.io.Serializable;


import com.WilliamLewis.BankingApp.Users.Customer;

/** This class exists merely to hold on to active Applications, BankData does the heavylifting with managing these applications
 * Only for holding onto the holder's info;
 * 
 * @author William
 *
 */
public class AccountApplication implements Serializable {
	private String accountType;
	private Customer accountHolder;
	private static final long serialVersionUID = 12321535234345L;

	public AccountApplication()
	{
		
	}
	public AccountApplication(Customer user, String type)
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
	public Customer getAccountHolder() {
		return accountHolder;
	}
	private void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}
}
