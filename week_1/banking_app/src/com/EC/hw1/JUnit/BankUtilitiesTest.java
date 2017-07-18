package com.EC.hw1.JUnit;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.EC.hw1.Model.Account;
import com.EC.hw1.Model.Admin;
import com.EC.hw1.Model.BankAccount;
import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;
import com.EC.hw1.Utilities.BankUtilities;


public class BankUtilitiesTest {
	
	private static BankAccount ba1 = new BankAccount();
	private static BankAccount ba2 = new BankAccount();
	private static BankAccount ba3 = new BankAccount();
	
	private static Customer c1 = new Customer();
	private static Customer c2 = new Customer();
	private static Customer c3 = new Customer();
	
	private static Account a1 = new Account();
	private static Account a2 = new Account();
	private static Account a3 = new Account();
	
	private static Employee e1 = new Employee();
	private static Employee e2 = new Employee();
	
	private static Admin ad1 = new Admin();
	
	@Before
	public void setUpBeforeClass(){
		ba1 = new BankAccount();
		ba2 = new BankAccount();
		ba3 = new BankAccount();
		
		c1 = new Customer("Elliot","Chen","ejchen","password",ba1);
		c2 = new Customer("Wendell","Phipps","wpipps","password", ba2);
		c3 = new Customer("Andrew","S","adrew","password",ba3);
		c1.setActive(true);
		c2.setActive(true);
		c3.setActive(true);
		
		a1 = new Account("employee1@gmail.com");
		a2 = new Account("admin1@gmail.com");
		a3 = new Account("employee2@gmail.com");
		
		e1 = new Employee("Nick","Jurzych","nicj","password",a1,new LinkedList<Customer>());
		e2 = new Employee("Blake","G","blazing","password",a3,new LinkedList<Customer>());
		
		ad1 = new Admin("Rovy","Tech", "rtech", "password", a2);
		e2.getCustList().add(c1);
	}
	
	
	
	@Test
	public void testWriteUser() {
		assertEquals(true, BankUtilities.writeUser(c1));
		assertEquals(true, BankUtilities.writeUser(e1));
		assertEquals(true, BankUtilities.writeUser(c3));
		assertEquals(true,BankUtilities.writeUser(ad1));
	}

	@Test
	public void testWriteEmployee() {
		assertEquals(true, BankUtilities.writeUser(e1));
		assertEquals(true, BankUtilities.writeUser(e2));
	}

	@Test
	public void testReadUser() {
		BankUtilities.writeUser(c1);
		Assert.assertNotNull(BankUtilities.readUser("ejchen"));
		Assert.assertNull(BankUtilities.readUser("abchen"));
	}

	
	@After
	public void cleanUpData(){
		File [] user = new File("Users/").listFiles();
		File [] employee = new File("Employees/").listFiles();
		
		for(File file : user){
			Path pth = Paths.get(file.getPath());
			BankUtilities.deleteUser(pth);
		}
		
		for(File file : employee){
			Path pth = Paths.get(file.getPath());
			BankUtilities.deleteUser(pth);
		}
	}

}
