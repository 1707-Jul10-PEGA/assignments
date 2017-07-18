package com.wh.banking_app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest {
    
    Customer c1,c2;
    Employee e1;
    
    @Before
    public void setup(){
	c1 = new Customer("Willy", 4231);
	c2 = new Customer("Billy", 1234);
	e1 = new Employee("Will", 12412);
    }

    @Test
    public void applyApplicationTest() {
	assertEquals(c1.applicationStatus(), "NO APPLICATION");
	c1.apply();
	c2.apply();
	assertEquals(c1.applicationStatus(), "PENDING");
	e1.approve(c1.getApplication());
	e1.deny(c2.getApplication());
	assertEquals(c1.applicationStatus(), "APPROVED");
	assertEquals(c2.applicationStatus(), "DENIED");
    }
    
    @Test
    public void viewBalance(){
	c1.apply();
	assertEquals(c1.viewBalance(), -1, 0);
	e1.approve(c1.getApplication());
	assertEquals(c1.viewBalance(), 0, 0);
    }
    
    @Test
    public void withdrawAndDepositTest(){
	c1.apply();
	assertEquals(c1.deposit(100), false);
	assertEquals(c1.withdraw(50), -1, 0);
	assertEquals(c1.viewBalance(), -1, 0);
	e1.approve(c1.getApplication());
	assertEquals(c1.deposit(100), true);
	assertEquals(c1.withdraw(50), 50, 0);
	assertEquals(c1.viewBalance(), 50, 0);
    }
}
