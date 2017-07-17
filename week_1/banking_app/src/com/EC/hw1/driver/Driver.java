package com.EC.hw1.driver;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.EC.hw1.Model.Admin;
import com.EC.hw1.Model.BankAccount;
import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;
import com.EC.hw1.Model.User;
import com.EC.hw1.Utilities.BankUtilities;

public class Driver {

	// private Set<Employee> empList = new HashSet<Employee>();
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = Logger.getRootLogger();
	public static void main(String[] args) {

		startApp();

	}

	private static void startApp() {

		boolean valid = true;

		while (valid) {
			printWelcome();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 3) {
					// switch case
					switch (tmp) {
					case 1:
						login();
						break;
					case 2:
						createAccount();
						break;
					case 3:
						scan.close();
						System.out.println("Good-bye!");
						valid = false;
					}
				} 
			} else {
				// clear invalid input
				scan.next();
			}

		}
	}

	private static void createAccount() {

		System.out.println("Please enter the following information to make an account");
		System.out.println("First name:");
		String firstName = scan.next();
		System.out.println("Last name: ");
		String lastName = scan.next();
		String username = null;
		for (boolean valid = true; valid;) {
			System.out.println("username: ");
			username = scan.next();
			Customer c2 = (Customer) BankUtilities.readUser(username);
			if (c2 != null) {
				System.out.println("This username already exist. Please choose another one");
			} else {
				valid = false;
			}
		}
		System.out.println("password: ");
		String password = scan.next();
		String email = null;
		for (boolean valid = true; valid;) {
			System.out.println("email: ");
			email = scan.next();
			if (email.contains("@")) {
				valid = false;
			} else {
				System.out.println("please enter a valid email address");
			}
		}
		BankAccount ba = new BankAccount(email, 0, 0, 0);
		Customer c = new Customer(firstName, lastName, username, password, ba);
		if (BankUtilities.assignBanker(c)) {
			System.out.println("A banker is looking at your application now. Please wait for us to contact you.\nThanks!");
			
		} else {
			System.out.println("Our bank is currently unemployeed. Please come back when we hire someone");
		}

	}

	private static void login() {

		boolean valid = true;

		while (valid) {
			printLogin();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 3) {
					// swtich case
					switch (tmp) {
					case 1:
						customerLogic();
						valid = false;
						break;
					case 2:
						employeeLogic();
						valid = false;
						break;
					case 3:
						adminLogic();
						valid = false;
						break;
					case 4:
						valid = false;
						break;
					}
				}
			} else {
				// clear invalid input
				scan.next();
			}
		}

	}

	private static void adminLogic() {
		User u = (User) getUserAccount();
		boolean valid = true;
		Admin admin = null;
		if (u == null) {
			return;
		} else if (u instanceof Admin) {
			admin = (Admin) u;
		} else {
			System.out.println("You are not a Administrator!");
			return;
		}
		System.out.println("Last Login: " + admin.getAccount().getLastLogin());
		log.trace("LOGINED: \n" + admin.toString());
		admin.getAccount().setLastLogin();
		BankUtilities.writeUser(admin);
		while (valid) {
			printAdminOptions();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 4) {
					// switch case
					switch (tmp) {
					case 1:
						admin.viewAllAccounts();
						break;
					case 2:
						admin.editAccount();
						break;
					case 3:
						valid = false;
						break;
					}
				}
			} else {
				//printAdminOptions();
				// clear invalid input
				scan.next();
			}

		}

	}

	private static void employeeLogic() {
		User u = (User) getUserAccount();
		Employee e = null;
		boolean valid = true;
		if (u == null) {
			return;
		} else if (u instanceof Employee) {
			e = (Employee) u;
		} else {
			System.out.println("You are not an employee");
			return;
		}

		System.out.println("Last Login: " + e.getAccount().getLastLogin());
		log.trace("LOGINED:\n" + e.toString());
		e.getAccount().setLastLogin();
		BankUtilities.writeUser(e);
		BankUtilities.writeEmployee(e);
		while (valid) {
			printEmployeeOptions();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 4) {
					// switch case
					switch (tmp) {
					case 1:
						e.checkApplications();
						break;
					case 2:
						System.out.println("Customer's username:");
						String cusUserName = scan.next();
						e.viewCustomerAsset(cusUserName);
						break;
					case 3:
						e.viewCustomerList();
						break;
					case 4:
						valid = false;
						break;
					}
				} 
			} else {
				// clear invalid input
				scan.next();
			}

		}

	}

	private static void customerLogic() {
		User u = (User) getUserAccount();
		boolean valid = true;
		Customer c = null;
		if (u == null) {
			return;
		} else if (u instanceof Customer) {
			c = (Customer) u;
		} else {
			System.out.println("You are not a customer!");
			return;
		}
		System.out.println("Last Login: " + c.getBankAccount().getLastLogin());
		log.trace("LOGINED:\n" + c.toString());
		c.getBankAccount().setLastLogin();
		BankUtilities.writeUser(c);
		while (valid) {
			printCustomerOptions();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 4) {
					// switch case
					switch (tmp) {
					case 1:
						System.out.println("Enter Amount $XXXX");
						if (scan.hasNextDouble()) {
							double money = scan.nextDouble();
							c.deposit(money);
							BankUtilities.writeUser(c);
						}
						break;
					case 2:
						System.out.println("Enter Amount $XXXX");
						if (scan.hasNextDouble()) {
							double money = scan.nextDouble();
							c.withdraw(money);
							BankUtilities.writeUser(c);
						}
						break;
					case 3:
						c.viewBalance();
						break;
					case 4:
						valid = false;
						break;
					}
				} 
			} else {
				// clear invalid input
				scan.next();
			}

		}
	}

	private static void printLogin() {
		System.out.println("Please pick a number between 1-4 to continue");
		System.out.println("(1)Customer");
		System.out.println("(2)Employee");
		System.out.println("(3)Admin");
		System.out.println("(4)Back");
	}

	private static void printWelcome() {
		System.out.println("Please pick a number between 1-3 to continue");
		System.out.println("(1)Login");
		System.out.println("(2)New Customer");
		System.out.println("(3)Close App");
	}

	private static void printAdminOptions() {
		System.out.println("Please enter a number between 1-3 to continue");
		System.out.println("(1)View All Accounts");
		System.out.println("(2)Edit an account");
		System.out.println("(3)Logout");
	}

	private static void printCustomerOptions() {
		System.out.println("Please pick a number between 1-4");
		System.out.println("(1)Deposit Money");
		System.out.println("(2)Withdraw Money");
		System.out.println("(3)View Bank Account");
		System.out.println("(4)Logout");

	}

	private static void printEmployeeOptions() {
		System.out.println("Please enter a number between 1-4 to continue");
		System.out.println("(1)Check Applications");
		System.out.println("(2)View a Customer's Asset");
		System.out.println("(3)Look at list of clients");
		System.out.println("(4)Logout");
	}

	private static User getUserAccount() {
		System.out.println("Please enter your user name");
		String username = scan.next();
		System.out.println("Please enter your user password");
		String password = scan.next();
		User u = BankUtilities.readUser(username);
		if (u == null) {
			return null;
		}
		if (u.getPassword().equals(password)) {
			return u;
		} else {
			System.out.println("Incorrect password!");
			return null;
		}

	}

}
