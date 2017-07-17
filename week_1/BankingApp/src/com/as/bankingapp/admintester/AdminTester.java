package com.as.bankingapp.admintester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.as.bankingapp.admin.Admin;

public class AdminTester {

	private Admin admin;
	
	@Before
	public void setUp() {
		admin = new Admin();
	}
	
	@Test
	public void testAddAccount() {
		//test adding an account id to the admin
		assertTrue("Check adding an id to the admin's managed list.", admin.addAccount(1));
		//test adding an account admin already has again
		assertFalse("Check adding an id to the admin's managed list that is already has.", admin.addAccount(1));
	}
}
