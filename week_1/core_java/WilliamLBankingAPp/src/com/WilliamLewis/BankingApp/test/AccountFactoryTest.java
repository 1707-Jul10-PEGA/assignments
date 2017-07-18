package com.WilliamLewis.BankingApp.test;

import org.junit.Test;

import com.WilliamLewis.BankingApp.AccountFactory.AccountFactory;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountFactoryTest {
		
		static AccountFactory AF;
		
		@BeforeClass
		public static void setUpBeforeClass()
		{
			AF = new AccountFactory();
		}
		@Test
		public void testCreateAccount(){
			Assert.assertEquals("Check for invalid tye", 0, AF.createAccount("notaType", "Username"));
			//No idea what to test the output against as it should be a randomly generated output?
			Integer check = AF.createAccount("Basic", "Username");
			int min = 0;
			int max = 100000;
			//Assert.assertThat((min<= check) && (check <= max));
		}
		@AfterClass
		public static void cleanUpAfterClass(){
			AF = null;
		}
	}

}
