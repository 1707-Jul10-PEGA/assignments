package com.WilliamLewis.BankingApp.BankData;

import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

/**
 * This Interface is for banking accounts, we only have a basic account at the moment, but
 * should functionality be added for multiply account types this class should considered.
 * @author William Lewis
 *
 */
public interface AccountInterface {
	public void view();
	public void deposit(double acc);
	public void withdraw(double acc);
	
}
