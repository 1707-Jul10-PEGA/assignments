package com.WilliamLewis.BankingApp.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

public class AccountTest {
	static Account ac;
	@BeforeClass
	public static void setUpBeforeClass()
	{
		ac = new Account("Testy", 123, 800);
	}
	@Test
	public void testCheckFunds(){
		Assert.assertFalse("Check for insufficiant funds: ", ac.checkFunds(100000));
		Assert.assertTrue("Check for sufficiant funds: ", ac.checkFunds(200));
		
	}
	@Test
	public void testDeposit(){
	
	}
	@Test
	public void testWithDraw(){
		
	
	}
	
	
	@AfterClass
	public static void cleanUpAfterClass(){
		ac = null;
	}
}
