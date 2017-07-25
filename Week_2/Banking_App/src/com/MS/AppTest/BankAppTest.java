package com.MS.AppTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.MS.BankApp.*;

public class BankAppTest {

	static Application app = new Application();
	static Admin admin = new Admin("Alice");
	static Employee employee = new Employee("Bob");
	static Customer customer = new Customer("Dave", "1", "100000", "null");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		app = new Application();
		app.generateFiller();
		//app.readFiller();
		
		admin = new Admin("Alice");
		
		employee = new Employee("Bob");
		
		customer = new Customer("Dave", "1", "100000", "null");
	}

	@Before
	public void setUp() throws Exception {
		//Resets any changes made between test applications
		app.readFiller();
	}

	@Test
	public void loginTest() {
		System.out.println("-------------LOGIN TEST--------------");
		//Login test
		assertTrue("Account Alice (premade admin) returns \"admin\"", "admin".equals(app.login("Alice")));
		assertTrue("Account Bob (premade employee) returns \"employee\"", "employee".equals(app.login("Bob")));
		assertTrue("Account Dave (premade customer) returns \"customer\"", "customer".equals(app.login("Dave")));
		assertTrue("Account George (new customer) returns \"customer\"", "customer".equals(app.login("George")));
		assertTrue("Entering null value as name returns \"null\"", "null".equals(app.login("")));
		System.out.println("-------------END LOGIN TEST--------------");
	}
	
	@Test
	public void adminTest(){
		System.out.println("-------------ADMIN TEST--------------");
		//Display accounts test
		System.out.println("\nDisplay all current customer accounts");
		admin.viewAccounts();
		assertTrue("Check if customer \"Dave\" really has 100000 in checking", "100000".equals(app.checlist[3]));
		assertTrue("Check if customer \"Dave\" really has null in savings", "null".equals(app.savlist[3]));
		
		//Change Account name test
		System.out.println("\nAttempt to change user Erin to Eve");
		String userchange = "Erin:Eve";
		admin.changeUser(userchange);
		assertTrue("Make sure \"Erin\" is now named \"Eve\"", "Eve".equals(app.namelist[4]));
		
		//Change Account amount test
		System.out.println("\nAttempt to change Dave's checking account");
		String balancechange = "Dave:checking:500";
		admin.changeBalance(balancechange);
		assertTrue("Make sure \"Dave\"'s checking balance is now 500", "500".equals(app.checlist[3]));
		
		System.out.println("\nAttempt to change Dave's savings account");
		balancechange = "Dave:savings:150";
		admin.changeBalance(balancechange);
		assertTrue("Make sure \"Dave\"'s savings balance is now 150", "150".equals(app.savlist[3]));
		System.out.println("-------------END ADMIN TEST--------------");
	}
	
	@Test
	public void employeeTest(){
		System.out.println("-------------EMPLOYEE TEST--------------");
		//Display test
		System.out.println("\nDisplay your current customer accounts");
		employee.viewAccounts();
		assertTrue("Check if customer \"Erin\" really has 50.5 in checking", "50.5".equals(app.checlist[4]));
		assertTrue("Check if customer \"Erin\" really has 300 in savings", "300".equals(app.savlist[4]));
		assertTrue("Ensure Bob is assigned to pre-made customers", "Bob".equals(app.assignedto[4]));
		assertFalse("Ensure Charlie is not assigned to pre-made customers", "Charlie".equals(app.assignedto[3]));
		
		//Approve Request test
		System.out.println("Attempt to approve for a savings account");
		app.requests[3] = "savings";
		String approveduser = "Dave";
		employee.approveAccounts(approveduser);
		assertTrue("Check if savings account has been created", "0".equals(app.savlist[3]));
		
		//Deny Request test
		System.out.println("\nAttempt to deny a savings account");
		app.requests[5] = "savings";
		String denieduser = "Frank";
		employee.denyAccounts(denieduser);
		assertTrue("Check if savings account has been denied","null".equals(app.savlist[5]));
		System.out.println("-------------END EMPLOYEE TEST--------------");
	}
	
	@Test
	public void CustomerTest(){
		System.out.println("-------------CUSTOMER TEST--------------");
		//Customer account view test
		System.out.println("\nDisplay logged-in customer info");
		customer.viewBalance();
		
		//Customer open account test
		System.out.println("Attempt to open a savings account");
		customer.openAccount("savings");
		assertTrue("Check if savings account request has been processed", "savings".equals(app.requests[3]));
		System.out.println("Attempt to open a checking account");
		customer.openAccount("checking");
		assertTrue("Check if checking account request has been processed", "checking".equals(app.requests[3]));
		
		//Customer deposit test
		System.out.println("Attempt to deposit 50 in checking account");
		String depositdata = "checking:50";
		customer.deposit(depositdata);
		assertTrue("Check if Dave's checking account now has 100050.0 in it", "100050.0".equals(app.checlist[3]));
		System.out.println("Attempt to deposit a negative number");
		depositdata = "checking:-100";
		customer.deposit(depositdata);
		assertFalse("Check to ensure the deposit did not go through", "99950.0".equals(app.checlist[3]));
		
		System.out.println("Attempt to deposit 50 in savings account");
		depositdata = "savings:50";
		customer.deposit(depositdata);
		assertFalse("Check if Dave's savings account is still null", "50".equals(app.savlist[3]));
		System.out.println("Attempt to deposit a negative number");
		depositdata = "savings:-100";
		customer.deposit(depositdata);
		assertFalse("Check to ensure the deposit did not go through", "99950.0".equals(app.savlist[3]));
		
		//Customer withdraw test
		System.out.println("Attempt to withdraw 50 from checking account (return it to 100k)");
		String withdrawdata = "checking:50";
		customer.withdraw(withdrawdata);
		assertTrue("Check if Dave's checking account now has 100000.0 in it", "100000.0".equals(app.checlist[3]));
		System.out.println("Attempt to withdraw a negative number");
		withdrawdata = "checking:-100";
		customer.deposit(withdrawdata);
		assertFalse("Check to ensure the withdraw did not go through", "100100.0".equals(app.checlist[3]));
		System.out.println("Attempt to withdraw more than the account holds");
		withdrawdata = "checking:200000";
		customer.withdraw(withdrawdata);
		assertFalse("Check if Dave's checking account still has 100000.0 in it", "100000".equals(app.checlist[3]));
		
		System.out.println("Check to make sure you cannot withdraw or deposit to a null account");
		depositdata = "savings:1";
		withdrawdata = "savings:1";
		System.out.println("Deposit:");
		customer.deposit(depositdata);
		assertTrue("Check if savings account is still null", "null".equals(app.savlist[3]));
		System.out.println("Withdraw:");
		customer.withdraw(withdrawdata);
		assertTrue("Check if savings account is still null", "null".equals(app.savlist[3]));
		
		System.out.println("-------------END CUSTOMER TEST--------------");
	}

}
