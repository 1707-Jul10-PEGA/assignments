package com.as.bankingapp.accounttester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.as.bankingapp.account.Account;

public class AccountTester {
	
	private Account ac;
	
	@Before
	public void setUp() {
		ac = new Account();
		ac.setActive(true);
		ac.setValue(20.0);
	}
	
	@Test
	public void testDeposit() {
		//test depositing a valid amount
		ac.deposit(20.5);
		assertEquals("Check depositing a valid amount of money.", 40.5, ac.getValue(), 0);
		//test depositing a negative amount
		ac.deposit(-10);
		assertEquals("Check depositing a negative amount doesn't affecct the value.", 40.5, ac.getValue(), 0);
		//test depositing on an inactive account
		ac.setActive(false);
		ac.deposit(10);
		assertEquals("Check depositing on an inactive account.", 40.5, ac.getValue(), 0);
	}
	
	@Test
	public void testWithdraw(){
		//test withdrawing a valid amount
		ac.withdraw(10);
		assertEquals("Check withdrawing a valid amount of money", 10, ac.getValue(), 0);
		//test withdrawing a negative amount
		ac.withdraw(-10);
		assertEquals("Check withdrawing a negative amount.", 10, ac.getValue(), 0);
		//test withdrawing more than the account has
		ac.withdraw(20);
		assertEquals("Check withdrawing more than the account has.", 10, ac.getValue(), 0);
		//test withdrawing on an inactive account
		ac.setActive(false);
		ac.withdraw(5);
		assertEquals("Check withdrawing on an inactive account.", 10, ac.getValue(), 0);
	}
}
