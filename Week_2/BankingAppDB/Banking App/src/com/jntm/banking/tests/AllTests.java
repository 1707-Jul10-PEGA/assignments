package com.jntm.banking.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jntm.banking.tools.Account;
import com.jntm.banking.users.Admin;
import com.jntm.banking.users.Customer;
import com.jntm.banking.users.Employee;
import com.jntm.banking.users.User;

public class AllTests {
	
	private static Admin admin = new Admin("Addie","Min","Admin77","password");
	private static Employee emp = new Employee("Emporio", "Loyee","Emp77","password");
	private static Customer cust = new Customer("Custer","Mer","cust77","password", emp.getUserID());
	private static Account acc = new Account(cust.getUserID());
	
	@BeforeClass
	public static void setupBeforeClass() {
		admin = new Admin("Addie","Min","Admin77","password");
		User.userList.add(admin);
		emp = new Employee("Emporio", "Loyee","Emp77","password");
		User.userList.add(emp);
		cust = new Customer("Custer","Mer","cust77","password", emp.getUserID());
		User.userList.add(cust);
		acc = new Account(cust.getUserID());
		Account.accList.add(acc);
	}
	
	//Admin tests
	@Test
	public void testSetBalance(){
		acc.setBalance(600.00);
		admin.setBalance(acc.getUniqueID(), 400);
		
		assertTrue("Balance should be equal",Double.parseDouble(acc.getBalance())==400.00);
	}
	
	//Customer tests
	@Test
	public void testWithdraw(){
		acc.setBalance(1000.00);
		cust.withdrawAccount(acc.getUniqueID(), 400.00);
		assertTrue("Balance should be equal",Double.parseDouble(acc.getBalance())==600.00);
	}
	
	@Test
	public void testDeposit(){
		acc.setBalance(1000.00);
		cust.depositAccount(acc.getUniqueID(), 400.00);
		assertTrue("Balance should be equal",Double.parseDouble(acc.getBalance())==1400.00);
	}
	
	
	
	
	
}