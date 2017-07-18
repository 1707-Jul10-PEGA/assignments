package com.WilliamLewis.BankingApp.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.WilliamLewis.BankingApp.AccountFactory.AccountFactory;
import com.WilliamLewis.BankingApp.BankData.BankData;
public class BankDataTest {

			static BankData BD;
			@BeforeClass
			public static void setUpBeforeClass()
			{
				BD = new BankData();
			}
			//How to test a Singleton?
			@AfterClass
			public static void cleanUpAfterClass(){
				BD = null;
			}
}
