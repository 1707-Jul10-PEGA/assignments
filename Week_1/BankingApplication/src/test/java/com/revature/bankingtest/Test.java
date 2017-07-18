package com.revature.bankingtest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import com.revature.banking.Administrator;
import com.revature.banking.Application;
import com.revature.banking.Main;
import com.revature.banking.UserFactory;

public class Test {
	private static Administrator admin;
	private static Application app;
	private static Main main = new Main();
	@BeforeClass
	public static void setUpBeforeClass(){
		admin = new Administrator("Jerry", "House", 34, "2234567890", "123 Maven Road", "jhouse", "jh123");
	}
	
	@org.junit.Test
	public void testSetAge(){
		assertFalse("Check negative age returns false", admin.setAge(-1));
		admin.setAge(50);
		assertEquals(50,admin.getAge());
	}
	
	@org.junit.Test
	public void testName(){
		assertFalse("Check negative age returns false", admin.setAge(-1));
		admin.setFirstName("Jenny");
		assertEquals("Jenny",admin.getFirstName());
		
	}
	
	@org.junit.Test
	public void testApplicationEquals() {
		app = new Application(admin,"saving",2400.00);
		assertTrue(app.equals(new Application(admin,"saving",2400.00)));
	}

}
