package com.cg.bankingapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class UserManagement {

	private Hashtable<String, User> users;
	private Queue<Customer> applications;
	private InputOutput userInput;

	private String pathToFile;

	public UserManagement() {
		pathToFile = "/Users/carlosgastelum/Documents/Revature/assignments/Week1/bankingapp/BankInfo.txt";
		users = new Hashtable<String, User>();
		applications = new LinkedList<Customer>();
		userInput = new InputOutput();

	}

	// Add Employee
	public void addEmployee(Employee e) {
		users.put(e.getUsername(), e);
	}

	// Removes an application from the queue
	private Customer getApplication() {
		return applications.poll();
	}

	// Check if username is taken
	private boolean checkIfUserExist(String username) {
		if (users.get(username) != null) {
			return true;
		}
		return false;
	}

	// Required input for a customer to apply for an account
	public Customer applyForAccount() {
		// Variables
		Customer c;
		String name, username, password, vp;
		int typeOfaccount;
		double amountToDeposit, checkingsDeposit, savingsDeposit;
		boolean exists;

		typeOfaccount = userInput.getInputInt("1.Checking\n2.Savings\n3.Both\nType of Account: ");

		name = userInput.getInputString("Enter name: ");

		do {
			username = userInput.getInputString("Enter username: ");
			exists = this.checkIfUserExist(username);
			if (exists) {
				System.out.println("User already exists");
			}
		} while (exists == true);

		do {
			password = userInput.getInputString("Enter password: ");
			vp = userInput.getInputString("Verify password: ");
		} while (!password.equals(vp));

		// Based on what type of account the user wants call the appropriate constructor
		if (typeOfaccount == 1 || typeOfaccount == 2) {
			amountToDeposit = userInput.getInputDouble("Deposit Amount: ");
			c = new Customer(name, username, password, typeOfaccount, amountToDeposit);
		} else {
			checkingsDeposit = userInput.getInputDouble("Checkings\nDeposit Amount: ");
			savingsDeposit = userInput.getInputDouble("Savings\nDeposit Amount: ");
			c = new Customer(name, username, password, checkingsDeposit, savingsDeposit);
		}

		return c;
	}

	public void addApplicationToQueue(Customer customer) {
		applications.add(customer);
	}

	public void populateHastable() {

		ArrayList<User> u = readFile();

		for (User i : u) {
			users.put(i.getUsername(), i);
		}

	}

	// Read a users from BankInfo.txt
	public ArrayList<User> readFile() {

		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(pathToFile))) {
			@SuppressWarnings("unchecked")
			ArrayList<User> u = (ArrayList<User>) input.readObject();
			return u;
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Write all users to BankInfo.txt
	public void writeToFile() {
		File file = new File("BankInfo.txt");

		ArrayList<User> u = new ArrayList<User>(users.values());
		try {
			if (file.createNewFile()) {
				this.pathToFile = file.getAbsolutePath();
				System.out.println("File BankInfo.txt Created. " + this.pathToFile);
				Admin admin = new Admin("admin", "root", "admin");
				users.put(admin.getUsername(), admin);
				/*
				 * Employee carlos = new Employee("carlos","gastelum", "123"); Employee pedro =
				 * new Employee("pedro","pedro", "123"); usermanagement.addEmployee(carlos);
				 * usermanagement.addEmployee(pedro); usermanagement.writeToFile();
				 */
			}
			try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(pathToFile))) {

				output.writeObject(u);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Login user
	public int login() {
		String username = userInput.getInputString("Username: ");
		String password = userInput.getInputString("Password: ");

		// Check if the user exists
		if (this.checkIfUserExist(username)) {
			User user = users.get(username);

			// User exist does the password match?
			if (password.equals(user.getPassword())) {
				this.ShowMenu(user);
				return 1;
			} else {
				return -1;
			}

		}

		return 0;
	}

	private void ShowMenu(User user) {
		// Direct to proper menu
		if ("admin".equals(user.getAccessRights())) {
			System.out.println("Login Successful");
			AdminMenu((Admin) user);
		} else if ("employee".equals(user.getAccessRights())) {
			System.out.println("Login Successful");
			EmployeeMenu((Employee) user);
		} else {
			if (((Customer) user).getApproved() == 1) {
				System.out.println("Login Successful");
				CustomerMenu((Customer) user);
			} else {
				System.out.println("Application was denied. Please talk to a banker.");
			}
		}

	}

	// Withdraw money from a customer account
	private int withdraw(Customer user) {
		double money;
		int response;

		if (user.getCustomerLevel() == 1) {
			money = userInput.getInputDouble("Enter amount to withdraw: ");
			System.out.println(user.withdraw(money, "checkings"));
		} else if (user.getCustomerLevel() == 2) {
			money = userInput.getInputDouble("Enter amount to withdraw: ");
			System.out.println(user.withdraw(money, "savings"));
		} else {
			do {
				response = userInput.getInputInt(
						"Please choose an account to withdraw from\n1.Checkings\n2.Savings\nEnter choice: ");
				if (response == 1) {
					money = userInput.getInputDouble("Enter amount to withdraw: ");
					System.out.println(user.withdraw(money, "checkings"));
				} else if (response == 2) {
					money = userInput.getInputDouble("Enter amount to withdraw: ");
					System.out.println(user.withdraw(money, "savings"));

				} else {
					System.out.println("Please choose a valid option.");
				}
			} while (response > 2);
		}
		return 0;
	}

	private int getCustomerBalance(Customer user) {
		System.out.println(user.getBalance());
		return 0;
	}

	// Deposit to customer account
	private int deposit(Customer user) {
		double money;
		int response;

		if (user.getCustomerLevel() == 1) {
			money = userInput.getInputDouble("Enter amount to deposit: ");
			System.out.println(user.deposit(money, "checkings"));
		} else if (user.getCustomerLevel() == 2) {
			money = userInput.getInputDouble("Enter amount to deposit: ");
			System.out.println(user.deposit(money, "savings"));
		} else {
			do {
				response = userInput.getInputInt(
						"Please choose an account to make a deposit from\n1.Checkings\n2.Savings\nEnter choice: ");
				if (response == 1) {
					money = userInput.getInputDouble("Enter amount: ");
					System.out.println(user.deposit(money, "checkings"));
				} else if (response == 2) {
					money = userInput.getInputDouble("Enter amount: ");
					System.out.println(user.deposit(money, "savings"));

				} else {
					System.out.println("Please choose a valid option.");
				}
			} while (response > 2);
		}
		return 0;
	}

	private void CustomerMenu(Customer user) {
		int response;

		String str = "1.Check account(s) Balance\n2.Withdraw money\n3.Make a deposit\n4.Exit\nEnter Response: ";
		System.out.println("Welcome " + user.getUsername());

		do {
			response = userInput.getInputInt(str);
			if (response == 1) {
				response = this.getCustomerBalance(user);
			} else if (response == 2) {
				response = this.withdraw(user);
			} else if (response == 3) {
				response = this.deposit(user);
			} else if (response > 4) {
				System.out.println("Please make a valid choice");
			}
		} while (response != 4);
	}

	// Check a customer account
	private int checkCustomerAccount(User user) {
		int response;
		String username = userInput.getInputString("Enter customer's username: ");
		Customer c = (Customer) users.get(username);
		if (c != null && c.getManagedby() == user.getUsername() && c.getApproved() == 1) {
			System.out.println("Name: " + c.getName() + "\n" + c.getBalance());
		} else if (c != null && c.getApproved() == 2) {
			System.out.println("Customer was not approved.");
			do {

				response = userInput.getInputInt("Would you like to approve it?\n1.Yes\n2.No\nEnter choice: ");
				if (response == 1) {
					c.setApproved(1);
					System.out.println(c.getName() + " approved.");
				} else if (response == 2) {
					System.out.println(c.getName() + " denied.");
				} else {
					System.out.println("Please select a valid response.");
				}
			} while (response > 2);

		} else if (c == null) {
			System.out.println("Customer not found.");
		}
		return 0;
	}

	private int getApplications(User user) {
		int response;
		Customer customer;

		customer = this.getApplication();
		if (customer != null) {
			System.out.println(customer.getName());
			do {
				response = userInput.getInputInt("1.Approve\n2.Deny\nEnter choice: ");
				if (response == 1 || response == 2) {
					customer.setApproved(response);
					customer.setManagedby(user.getUsername());
					users.put(customer.getUsername(), customer);

				} else {
					System.out.println("Please select a valid response.");
				}
			} while (response > 2);
		} else {
			System.out.println("No new applications. Check back later");
		}

		return 0;
	}

	private int removeUser(User user) {
		String str = "Are you sure you want to remove " + user.getUsername() + "\n1.Yes\n2.No\n3.Exit\nEnter choice: ";
		int response;
		do {
			response = userInput.getInputInt(str);
			if (response == 1) {
				System.out.println(user.getUsername() + " was succefully removed.");
				users.remove(user.getUsername());
				return 0;
			} else if (response == 2) {
				System.out.println(user.getUsername() + " was not removed.");
				return 0;
			} else {
				System.out.println("Please select a valid response.");
			}
		} while (response == -1 );

		return 0;
	}

	private int manageEmployees() {
		String str = "1.List employees\n2.Update an employee information\n3.Add an employee\n4.Remove an employee\n5.Exit\nEnter choice: ";
		String str1;
		Employee employee;
		int response;

		do {
			response = userInput.getInputInt(str);
			if (response == 1) {
				ArrayList<User> user = new ArrayList<User>(users.values());
				int counter = 1;
				for (User i : user) {
					if (i.getAccessRights().equals("employee")) {
						System.out.println(counter + "." + i.toString());
						counter++;
					}
				}
				System.out.println();
			} else if (response == 2) {
				String e = userInput.getInputString("Enter employee username: ");
				employee = (Employee) users.get(e);
				str1 = "1.Change name\n2.Change username\n3.Change Password\n4.Exit\nEnter choice: ";
				if (employee != null) {
					do {
						response = userInput.getInputInt(str1);
						if (response == 1) {
							String name = userInput.getInputString("Enter new name: ");
							users.get(employee.getUsername()).setName(name);
						} else if (response == 2) {
							String username = userInput.getInputString("Enter new username: ");
							users.get(employee.getUsername()).setUsername(username);
						} else if (response == 3) {
							String password = userInput.getInputString("Enter new password: ");
							users.get(employee.getUsername()).setPassword(password);
						} else if (response > 4) {
							System.out.println("Please make a valid choice");
						}
					} while (response != 4);
				} else {
					System.out.println("Employee not found.");
				}
				response = 0;
			} else if (response == 3) {
				String username = userInput.getInputString("Enter new employee username: ");
				boolean flag = this.checkIfUserExist(username);
				if (flag) {
					System.out.println("User already exists");
				} else {
					String name = userInput.getInputString("Enter new name: ");
					String password = userInput.getInputString("Enter new password: ");
					employee = new Employee(name, username, password);

				}
			} else if (response == 4) {
				String e = userInput.getInputString("Enter employee username: ");
				if (users.get(e) != null && users.get(e).getAccessRights().equals("employee")) {
					;
					this.removeUser(users.get(e));

				} else {
					System.out.println("Employee not found.");
				}
			} else if (response > 5) {
				System.out.println("Please make a valid choice");
			}
		} while (response != 5);

		return 0;
	}

	private int manageCustomers(Admin admin) {
		String str = "1.List customers\n2.Update a customer's information\n3.Add a customer\n4.Remove a customer\n5.Applications waiting for approval\n6.Exit\nEnter choice: ";
		String str1;
		Customer customer;
		int response;

		do {
			response = userInput.getInputInt(str);
			if (response == 1) {
				ArrayList<User> user = new ArrayList<User>(users.values());
				int counter = 1;
				for (User i : user) {
					if (i.getAccessRights().equals("customer")) {
						System.out.println(counter + "." + i.toString());
						counter++;
					}
				}
				System.out.println();
			} else if (response == 2) {
				String e = userInput.getInputString("Enter customer username: ");
				customer = (Customer) users.get(e);
				str1 = "1.Change name\n2.Change username\n3.Change Password\n4.Update Customer Balance\n5.Exit\nEnter choice: ";
				if (customer != null) {
					do {
						response = userInput.getInputInt(str1);
						if (response == 1) {
							String name = userInput.getInputString("Enter new name: ");
							users.get(customer.getUsername()).setName(name);
						} else if (response == 2) {

						} else if (response > 4) {
							System.out.println("Please make a valid choice");
						}
					} while (response != 4);
				} else {
					System.out.println("Customer not found.");
				}
				response = 0;
			} else if (response == 4) {
				String e = userInput.getInputString("Enter customer username: ");
				customer = (Customer) users.get(e);

				if (customer != null) {
					this.removeUser(customer);
				} else {
					System.out.println("Customer not found.");
				}
			} 
			else if( response == 5) {
				response = this.getApplications(admin);
			}
			else if (response > 6) {
				System.out.println("Please make a valid choice");
			}
		} while (response != 6);

		return 0;
	}

	private void AdminMenu(Admin user) {
		int i;
		String str = "1.Manage Employees\n2.Manage Customers\n3.Exit\nEnter choice: ";

		do {
			i = userInput.getInputInt(str);
			if (i == 1) {
				i = this.manageEmployees();
			} else if (i == 2) {
				i = this.manageCustomers(user);
				/*
				 * str1 =
				 * "1.List customers\n2.Manage a customer account\n3.Check applications waiting approval\n4.Exit"
				 * ; i = userInput.getInputInt(str1); i = this.getApplications(user); i =
				 * this.checkCustomerAccount(user);
				 */
			} else if (i > 3) {
				System.out.println("Please make a valid choice");
			}
		} while (i != 3);
	}

	private void EmployeeMenu(Employee user) {

		String str = "1.Check a customer account\n2.Check applications waiting approval\n3.Exit\nEnter choice: ";
		int i;

		System.out.println("Welcome " + user.getUsername());

		do {
			i = userInput.getInputInt(str);
			if (i == 1) {
				this.checkCustomerAccount(user);
			} else if (i == 2) {
				i = this.getApplications(user);
			} else if (i > 3) {
				System.out.println("Please make a valid choice");
			}
		} while (i != 3);

	}

}
