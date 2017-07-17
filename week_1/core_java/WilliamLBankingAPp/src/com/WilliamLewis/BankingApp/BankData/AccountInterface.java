package com.WilliamLewis.BankingApp.BankData;

import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

/**
 * This Interface is for banking accounts, wooo
 * @author William Lewis
 *
 */
public interface AccountInterface {
	public void view();
	public void deposit(double acc);
	public void withdraw(double acc);
	
}
