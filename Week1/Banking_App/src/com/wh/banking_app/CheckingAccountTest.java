package com.wh.banking_app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {

    CheckingAccount cAcc, cAcc2;
    @Before
    public void setup() {
	cAcc = new CheckingAccount();
	cAcc2 = new CheckingAccount();
    }
    
    @Test
    public void depositAndviewBalanceTest() {
	assertTrue(cAcc.deposit(100.0));
	assertEquals(100.0D,cAcc.viewBalance(), 0);
    }
    
    @Test
    public void withdrawTest(){
	cAcc.deposit(100);
	assertEquals(50.0, cAcc.withdraw(50.0), 0);
	assertEquals(50.0, cAcc.viewBalance(), 0);
	assertEquals(-1, cAcc.withdraw(100), 0);
    }
    
    @Test
    public void transferTest(){
	cAcc.deposit(50);
	assertTrue(cAcc.transfer(25.0, cAcc2));
	assertEquals(cAcc2.viewBalance(),cAcc.viewBalance(), 0);
	assertSame(false, cAcc.transfer(50.0, cAcc2));
    }

}
