package com.WilliamLewis.BankingApp.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.WilliamLewis.BankingApp.AccountFactory.AccountFactory;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.Users.Admin;
import com.WilliamLewis.BankingApp.Users.Customer;
import com.WilliamLewis.BankingApp.Users.Employee;
public class BankDataTest {

			@BeforeClass
			public static void setUpBeforeClass()
			{
				BankData.clearForTesting();
				BankData.getTestInstance();
				Employee Master = new Employee("UserName" , "emp");
				Customer Bob = new Customer("User", "123");
				Customer Bill = new Customer("UserTwo", "abc");
				Admin headHoncho = new Admin();
				
				Bob.submitApplication();
				Bob.submitApplication();
				Master.approveAll();
				
				
			}
			@Test
			public static void TestStuff()
			{
				
			}
			@AfterClass
			public static void cleanUpAfterClass(){
				BankData.clearForTesting();
			}
}
