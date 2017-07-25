package com.wh.banking_appTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wh.banking_app.Customer;
import com.wh.banking_app.Employee;

public class EmployeeTest {
    static Customer c1, c2, c3;
    static Employee e1;

    @BeforeClass
    public static void setup() {
	c1 = new Customer("Billy", 1234);
	c2 = new Customer("Camal", 1234);
	c3 = new Customer("Cama2", 12341);
	e1 = new Employee("Elly", 4321);
    }

    @Test
    public void approveCustomer() {
	assertEquals(c1.viewBalance(), -1, 0);
	c1.apply();
	assertTrue(e1.approve(c1.getCheckingAccount()));
	assertEquals(c1.viewBalance(), 0, 0);
    }
    
    @Test
    public void denyCustomer() {
	assertEquals(c2.viewBalance(), -1, 0);
	c2.apply();
	assertFalse(e1.deny(c2.getCheckingAccount()));
	assertEquals(c2.viewBalance(), -1, 0);
    }
    
    @Test
    public void viewCustomerBalance() {
	c3.apply();
	e1.approve(c3.getCheckingAccount());
	
    }
}
