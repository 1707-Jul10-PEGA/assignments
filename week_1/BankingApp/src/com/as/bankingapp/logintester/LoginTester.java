package com.as.bankingapp.logintester;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.as.bankingapp.customer.Customer;
import com.as.bankingapp.login.Login;
import com.as.bankingapp.user.User;

public class LoginTester {

	private String user;
	
	private String pass;
	
	private List<User> userList;
	
	@Before
	public void setUp() {
		userList = new ArrayList<User>();
		userList.add(new Customer("bill", "frog"));
		userList.add(new Customer("daisy", "vehicle"));
		userList.add(new Customer("ashley", "cookie"));
	}
	
	@Test
	public void testLogin() {
		user = "ashley";
		pass = "cookie";
		User testUser;
		//check loggin in with valid credentials
		testUser = Login.login(user, pass, userList);
		assertTrue("Checking that logging in with valid credentials returns a non-null user.", testUser != null);
		//check logging in with invalid credentials
		user = "lilly";
		pass = "grass";
		testUser = Login.login(user, pass, userList);
		assertTrue("Checking that logging in with invalid credentials returns a null user.", testUser == null);
	}
}
