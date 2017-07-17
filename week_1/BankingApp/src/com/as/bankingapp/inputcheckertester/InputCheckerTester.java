package com.as.bankingapp.inputcheckertester;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.as.bankingapp.admin.Admin;
import com.as.bankingapp.customer.Customer;
import com.as.bankingapp.employee.Employee;
import com.as.bankingapp.inputchecker.InputChecker;
import com.as.bankingapp.user.User;

public class InputCheckerTester {

	private String user;
	
	private String pass;
	
	@Test
	public void testIsValidUserName() {
		//Checking valid user name
		user = "marrie";
		assertTrue("Checking that a valid username returns true.", InputChecker.isValidUserName(user));
		//checking invalid user name
		user = "marrie smith";
		assertFalse("Checking that an invalid username returns false.", InputChecker.isValidUserName(user));
		//checking username of "exit" returns false
		user = "exit";
		assertFalse("Checking that a username of 'exit' returns false.", InputChecker.isValidUserName(user));
	}
	
	@Test
	public void testIsNumber() {
		//check that an integer returns true
		assertTrue("Checking that an integer returns true.", InputChecker.isNumber("5"));
		//check that a double returns true
		assertTrue("Checking that a double returns true.", InputChecker.isNumber("5.5"));
		//check that a non-number returns false
		assertFalse("Checking that a non-number returns false.", InputChecker.isNumber("five"));
	}
	
	@Test
	public void testIsValidCustomerCommand() {
		//check command view
		assertTrue("Checking that 'view' is valid customer command.", InputChecker.isValidCustomerCommand("view"));
		//check command apply
		assertTrue("Checking that 'apply' is valid customer command.", InputChecker.isValidCustomerCommand("apply"));
		//check command deposit
		assertTrue("Checking that 'deposit' [value] is valid customer command.", InputChecker.isValidCustomerCommand("deposit 10"));
		//check command withdraw
		assertTrue("Checking that 'withdraw' [value] is valid customer command.", InputChecker.isValidCustomerCommand("withdraw 10"));
		//check invalid command
		assertFalse("Checking an invalid customer command.", InputChecker.isValidCustomerCommand("approve"));
	}
	
	@Test
	public void testIsValidEmployeeCommand() {
		//check command viewp
		assertTrue("Checking that 'viewp' is a valid employee command.", InputChecker.isValidEmployeeCommand("viewp"));
		//check command view [id]
		assertTrue("Checking that 'view' [id] is a valid employee command.", InputChecker.isValidEmployeeCommand("view 1"));
		//check command approve [id]
		assertTrue("Checking that 'approve' [id] is a valid employee command.", InputChecker.isValidEmployeeCommand("approve 1"));
		//check command deny [id]
		assertTrue("Checking that 'deny' [id] is a valid employee command.", InputChecker.isValidEmployeeCommand("deny 1"));
		//check invalid command
		assertFalse("Checking an invalid employee command.", InputChecker.isValidEmployeeCommand("set 1 20"));
	}
	
	@Test
	public void testIsValidAdminCommand() {
		//check command viewp
				assertTrue("Checking that 'viewp' is a valid admin command.", InputChecker.isValidAdminCommand("viewp"));
				//check command view [id]
				assertTrue("Checking that 'view' [id] is a valid admin command.", InputChecker.isValidAdminCommand("view 1"));
				//check command approve [id]
				assertTrue("Checking that 'approve' [id] is a valid admin command.", InputChecker.isValidAdminCommand("approve 1"));
				//check command deny [id]
				assertTrue("Checking that 'deny' [id] is a valid admin command.", InputChecker.isValidAdminCommand("deny 1"));
				//check command viewall
				assertTrue("Checking that 'viewall' is a valid admin command.", InputChecker.isValidAdminCommand("viewall"));
				//check command set [id] [value]
				assertTrue("Checking that 'set' [id] [value] is a valid admin command.", InputChecker.isValidAdminCommand("set 1 30"));
				//check an invalid command
				assertFalse("Checking an invalid command.", InputChecker.isValidAdminCommand("buy 2 34"));
	}
	
	@Test
	public void testIsValidCommand() {
		User testUser = null;
		//check "exit"
		assertTrue("Checking 'exit' command.", InputChecker.isValidCommand("exit", testUser));
		//check "loggout"
		assertTrue("Checking 'loggout' command.", InputChecker.isValidCommand("loggout", testUser));
		//check "commands"
		assertTrue("Checking 'commands' command.", InputChecker.isValidCommand("commands", testUser));
		//check customer command
		testUser = new Customer();
		assertTrue("Checking that isValidCommand recognizes a Customer.", InputChecker.isValidCommand("apply", testUser));
		//check employee command
		testUser= new Employee();
		assertTrue("Checking that isValidCommand recognizes an Employee.", InputChecker.isValidCommand("approve 1", testUser));
		//check admin command
		testUser = new Admin();
		assertTrue("Checking that isValidCommand recognizes an Admin.", InputChecker.isValidCommand("set 1 10", testUser));
	}
	
}
