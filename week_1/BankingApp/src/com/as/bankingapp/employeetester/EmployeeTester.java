package com.as.bankingapp.employeetester;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.as.bankingapp.employee.Employee;

public class EmployeeTester {

private Employee employee;
	
	@Before
	public void setUp() {
		employee = new Employee();
	}
	
	@Test
	public void testAddAccount() {
		//test adding an account id to the employee
		assertTrue("Check adding an id to the employee's managed list.", employee.addAccount(1));
		//test adding an account employee already has again
		assertFalse("Check adding an id to the employee's managed list that is already has.", employee.addAccount(1));
	}
}
