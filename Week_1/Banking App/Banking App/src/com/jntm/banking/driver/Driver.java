package com.jntm.banking.driver;

import java.util.Scanner;

import com.jntm.banking.tools.Account;
import com.jntm.banking.tools.Application;
import com.jntm.banking.users.Admin;
import com.jntm.banking.users.Customer;
import com.jntm.banking.users.Employee;
import com.jntm.banking.users.User;
import org.apache.log4j.Logger;

public class Driver {

	static Scanner scan = new Scanner(System.in);

	private static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {

		log.trace("Program Started.");

		String input = "";
		// Welcome users with a fun greeting
		System.out.println("Welcome to the Bank!");

		// Initialize all ArrayLists used in program from text files
		Account.readAccounts();
		User.readUsers();
		Application.readApplications();

//		for (User x : User.userList) {
//			System.out.println(x.getfName() + " " + x.getUserID());
//		}

		// Account.accList.clear();
		// User.userList.clear();
		// Application.appList.clear();

		// //A helpful guide for remembering passwords and such
		// Admin a1 = new Admin("Jake", "Maynard", "Jake","pass");
		// Admin a2 = new Admin("Ad", "Man", "Ad","pass");
		// User.userList.add(a1);
		// User.userList.add(a2);
		//
		// Employee e1 = new Employee("Sam", "Sung", "Sam", "pass");
		// Employee e2 = new Employee("Aqua", "Fina", "Aqua", "pass");
		// Employee e3 = new Employee("Gold", "Fish", "Gold", "pass");
		// User.userList.add(e1);
		// User.userList.add(e2);
		// User.userList.add(e3);
		//
		// Customer c1 = new Customer("George", "Washington", "amer", "pass",
		// e1.getUserID());
		// Customer c2 = new Customer("George", "Michaels", "gogo", "pass",
		// e2.getUserID());
		// Customer c3 = new Customer("George", "Jetson", "spac", "pass",
		// e1.getUserID());
		// Customer c4 = new Customer("George", "O'Jungle", "jung", "pass",
		// e3.getUserID());
		// User.userList.add(c1);
		// User.userList.add(c2);
		// User.userList.add(c3);
		// User.userList.add(c4);
		//
		// Account ac1 = new Account(c1.getUserID());
		// Account.accList.add(ac1);
		// c1.depositAccount(ac1.getUniqueID(), 34.45);
		// Account ac2 = new Account(c2.getUserID());
		// Account.accList.add(ac2);
		// c2.depositAccount(ac2.getUniqueID(), 98.09);
		// Account ac3 = new Account(c3.getUserID());
		// Account.accList.add(ac3);
		// c3.depositAccount(ac3.getUniqueID(), 33.33);
		// Account ac4 = new Account(c4.getUserID());
		// Account.accList.add(ac4);
		// c4.depositAccount(ac4.getUniqueID(), 44.44);
		// Account ac5 = new Account(c1.getUserID());
		// Account.accList.add(ac5);
		// c1.depositAccount(ac5.getUniqueID(), 23000.00);

		boolean mainGate = false;
		while (!mainGate) {
			log.trace("Entering Main Menu.");
			// Provide main menu
			System.out.println("Would you like to login or make a new Account?");
			System.out.println("1) Login\n2) Make New Account\n3) Quit");

			// Take input
			input = scan.nextLine();

			// Ensure Proper input
			while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
				System.out.println("Please enter a valid option.");
				System.out.println("1) Login\n2) Make New Account\n3) Quit");
				input = scan.nextLine();
			}

			if ("1".equals(input)) {
				logIn();
			} else if ("2".equals(input)) {
				makeNewAccount();
			} else if ("3".equals(input)) {
				mainGate = true;
				System.out.println("Quitting...");
				scan.close();
			} else {
				System.out.println("There has been an error.");
			}
		}
		// close scanner

		// Close all the ArrayLists and save text files for later use
		Application.writeApplications();
		Account.writeAccounts();
		User.writeUsers();
		log.trace("Program Closing.\n\n");
	}

	public static void logIn() {
		log.trace("Login started.");
		String username = "", password = "";

		System.out.println("Please input a username.");
		username = scan.nextLine();
		System.out.println("Please input a password.");
		password = scan.nextLine();

		log.trace("Attempted login by: " + username + " " + password);
		User user = null;
		// Check userlist for a match
		boolean gate = false;
		for (User u : User.userList) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				user = u;
				gate = true;
			}
		}
		if (!gate) {
			log.trace("Login failed, returning to main menu.");
			System.out.println("That username or password was wrong!");
			return;
		}

		log.trace(user.getfName() + " " + user.getlName() + " (" + user.getUserID() + ") logged in.");
		optionMenu(user);

	}

	public static void optionMenu(User user) {
		String input = "";
		boolean flag = false;
		while (!flag) {
			switch (user.getType()) {

			case "Customer":
				log.trace("User " + user.getfName() + " is a customer.");
				Customer cust = (Customer) user;
				System.out.println("\nHello, " + cust.getfName());
				System.out.println(
						"1) Apply for account\n2) View account balances\n3) Withdraw Money\n4) Deposit Money\n5) Log Out");
				input = scan.nextLine();

				while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")
						&& !input.equals("5")) {
					System.out.println("Pick a valid option.");
					input = scan.nextLine();
				}

				if ("1".equals(input)) {
					log.trace("User " + user.getfName() + " is applying for an account.");
					cust.applyForAccount();
					System.out.println("Application Submitted!");
				} else if ("2".equals(input)) {
					log.trace("User " + user.getfName() + " is checking an account.");
					cust.CheckAccount();
				} else if ("3".equals(input)) {
					log.trace("User " + user.getfName() + " is withdrawing from an account.");
					System.out.println("These are your accounts:");
					for (Account acc : Account.accList) {
						if (acc.getOwnerID().equals(cust.getUserID())) {
							System.out.println(acc);
						}
					}

					System.out.println("Which account will you withdraw from?");
					String id = scan.nextLine();
					System.out.println("How much will you withdraw?");
					String sum = scan.nextLine();
					log.trace("Attempted withdrawal from Account #" + id + " of $" + sum);
					cust.withdrawAccount(id, Double.parseDouble(sum));
				} else if ("4".equals(input)) {
					log.trace("User " + user.getfName() + " is depositing to an account.");
					System.out.println("These are your accounts:");
					for (Account acc : Account.accList) {
						if (acc.getOwnerID().equals(cust.getUserID())) {
							System.out.println(acc);
						}
					}

					System.out.println("Which account will you deposit to?");
					String id = scan.nextLine();
					System.out.println("How much will you deposit?");
					String sum = scan.nextLine();
					log.trace("Attempt to deposit $" + sum + " to Account #" + id);
					cust.depositAccount(id, Double.parseDouble(sum));
				} else if ("5".equals(input)) {
					log.trace("Logging out.");
					System.out.println("Logging out...");
					flag = true;
				} else {
					log.trace("Customer error state reached.");
				}

				break;

			case "Employee":

				Employee emp = ((Employee) user);
				log.trace("User " + emp.getfName() + " is an employee.");
				System.out.println("Hello, " + emp.getfName());
				System.out.println("1) Review Applications\n2) View Customer Accounts\n3) Log Out");
				input = scan.nextLine();

				while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
					System.out.println("Pick a valid option.");
					input = scan.nextLine();
				}

				if ("1".equals(input)) {
					log.trace("User" + emp.getUserID() + " is reviewing applications");
					emp.reviewApplications();
				} else if ("2".equals(input)) {
					log.trace("User" + emp.getUserID() + " is viewing accounts.");
					System.out.println("These are your customer accounts:");

					for (User u : User.userList) {
						if (u.getType().equals("Customer")) {
							Customer c = ((Customer) u);
							emp.viewAccounts(c);
						}
					}

				} else if ("3".equals(input)) {
					log.trace("Logging out.");
					System.out.println("Logging Out...");
					flag = true;
				} else {
					log.trace("Employee error state.");
				}

				break;

			case "Admin":

				Admin admin = ((Admin) user);
				System.out.println("Hello, " + admin.getfName());
				System.out.println("1) View Accounts\n2) Edit Accounts\n3) Review Applications\n4) Log Out");
				input = scan.nextLine();

				while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
					System.out.println("Pick a valid option.");
					input = scan.nextLine();
				}

				if (input.equals("1")) {
					// View Accounts

					log.trace("User" + admin.getUserID() + " is viewing accounts.");
					System.out.println("These are the customer accounts:");

					for (User u : User.userList) {
						if (u.getType().equals("Customer")) {
							Customer c = ((Customer) u);
							admin.viewAccounts(c);
						}
					}

				} else if (input.equals("2")) {
					// Edit Accounts
					input = "";
					System.out.println("Edit a user or banking account?\n1)User Account\n2)Bank Account\n3)Quit");
					input = scan.nextLine();

					while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
						System.out.println("Pick a valid option.");
						input = scan.nextLine();
					}

					if (input.equals("1")) {
						log.trace("Alter user account chosen");
						System.out.println("Select a User ID.");
						for (User u : User.userList) {
							if (!u.getType().equals("Admin")) {
								System.out.println(u.getfName() + " " + u.getlName() + " " + u.getUserID());
							}
						}

						input = scan.nextLine();

						for (User u : User.userList) {
							if (u.getUserID().equals(input)) {
								boolean deepflag = false;
								while (!deepflag) {
									System.out.println("What field will you edit?");
									System.out.println("1)First Name/n2)Last Name/n3)Username/n4)Password/n5)Quit");

									input = scan.nextLine();

									while (!input.equals("1") && !input.equals("2") && !input.equals("3")
											&& !input.equals("4") && !input.equals("5")) {
										System.out.println("Pick a valid option.");
										input = scan.nextLine();
									}

									if (input.equals("1")) {
										System.out.println("What's the new First Name?");
										input = scan.nextLine();
										u.setfName(input);
									} else if (input.equals("2")) {
										System.out.println("What's the new Last Name?");
										input = scan.nextLine();
										u.setlName(input);
									} else if (input.equals("3")) {
										System.out.println("What's the new Username?");
										input = scan.nextLine();
										u.setUsername(input);
									} else if (input.equals("4")) {
										System.out.println("What's the new Password?");
										input = scan.nextLine();
										u.setPassword(input);
									} else if (input.equals("5")) {
										System.out.println("Quitting.");
										deepflag = true;
									}

								}
								break;
							}
						}

					} else if (input.equals("2")) {
						log.trace("Alter bank account chosen");
						System.out.println("Select an account number.");

						for (Account acc : Account.accList) {
							System.out.println(acc.toString());
						}

						input = scan.nextLine();
						System.out.println("What is the new balance?");
						String num = scan.nextLine();
						admin.setBalance(input, Double.parseDouble(num));

					} else if (input.equals("3")) {
						System.out.println("Returning to menu.");
					}

				} else if (input.equals("3")) {
					// Review Apps
					admin.reviewApplications();
				} else if (input.equals("4")) {
					// Log out
					log.trace("Logging out.");
					System.out.println("Logging out...");
					flag = true;
				}

				break;

			}
		}
	}

	public static void makeNewAccount() {
		log.trace("Making New Account");
		String username = "", password = "";

		System.out.println("Welcome to the Bank. Are you a 1)customer or an 2)employee?");

		String input = "";

		while (!input.equals("1") && !input.equals("2") && !input.equals("ADMIN")) {
			System.out.println("Pick a valid option.");
			input = scan.nextLine();
		}
		String type = "";
		if (input.equals("1")) {
			type = "Customer";
		} else if (input.equals("2")) {
			type = "Employee";
		} else if (input.equals("ADMIN")) {
			type = "Admin";
		} else {
			log.trace("Not a valid state.");
			type = "Customer";
		}
		String fname = "", lname = "";

		System.out.println("What's your first name?");
		fname = scan.nextLine();
		System.out.println("What's your last name?");
		lname = scan.nextLine();
		System.out.println("Please input a username.");
		username = scan.nextLine();
		System.out.println("Please input a password.");
		password = scan.nextLine();

		User u = null;
		if (type.equals("Customer")) {
			String id = "";
			for (User user : User.userList) {
				if (user.getType().equals("Employee")) {
					id = user.getUserID();
					break;
				}
			}

			u = new Customer(fname, lname, username, password, id);
			User.userList.add(u);
			log.trace("A new " + u.getType() + " has been created.");
		} else if (type.equals("Employee")) {
			u = new Employee(fname, lname, username, password);
			User.userList.add(u);
			log.trace("A new " + u.getType() + " has been created.");
		} else if (type.equals("Admin")) {
			u = new Admin(fname, lname, username, password);
			User.userList.add(u);
			log.trace("A new " + u.getType() + " has been created.");
		} else {
			log.trace("Error making new user.");
		}

		System.out.println("Welcome to our bank, " + u.getfName() + ". You are account #" + u.getUserID());
		System.out.println("Logging out...");

	}

}
