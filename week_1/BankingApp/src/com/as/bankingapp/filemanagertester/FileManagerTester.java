package com.as.bankingapp.filemanagertester;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.as.bankingapp.admin.Admin;
import com.as.bankingapp.customer.Customer;
import com.as.bankingapp.employee.Employee;
import com.as.bankingapp.filemanager.FileManager;
import com.as.bankingapp.user.User;

public class FileManagerTester {
	
	private String filename = "testManager.txt";
	
	private List<User> userList;
	
	@Before
	public void setUp() {
		userList = new ArrayList<User>();
	}
	
	@After
	public void tearDown() {
		File file = new File(filename);
		if (file.exists()) {
			file.delete();
		}
	}
	
	@Test
	public void testWritingOutUsers() {
		userList.add(new Customer("Geoff", "jack"));
		userList.add(new Employee("Frank", "queen"));
		userList.add(new Admin("Larry", "king"));
		File file = new File(filename);
		FileManager.writeOutUsers(filename, userList);
		assertTrue("Checking that write to file generates a file.", file.exists());
	}
	
	@Test
	public void testReadingInUsers() {
		userList.add(new Customer("Geoff", "jack"));
		userList.add(new Employee("Frank", "queen"));
		userList.add(new Admin("Larry", "king"));
		FileManager.writeOutUsers(filename, userList);
		List<User> testList = new ArrayList<User>();
		FileManager.readInUsers(filename, testList);
		assertTrue("Checking that reading in list generates correct object.", testList.equals(userList));
		//Check that attempting to read from a non-existent file doesn't alter the user list.
		testList = new ArrayList<User>();
		FileManager.readInUsers("bogusName", testList);
		assertTrue("Checking the case that the filename doesn't exist.", testList.isEmpty());
	}
}
