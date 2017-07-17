package com.dv.bankingapp;

public class Login implements LoginInterface {

	@Override
	public void printCodes() {
		System.out.println("Enter one of the codes below, or any other number to exit: ");
		System.out.println("0: Login");
		System.out.println("1: Create customer account");
		System.out.println("2: Create employee account");
		System.out.println("3: Create admin account\n");
	}

	@Override
	public int promptWelcome() {
		int code = 0;
	
		System.out.println("===== Welcome =====\n");
		printCodes();

		// ensure user enters an integer 
		try {
			code = Integer.parseInt(Driver.read.nextLine());
			return code;
		}
		
		catch (NumberFormatException e) {
			System.out.println("Input entered was not a number. Exiting ...");
		}
		
		return -1;
	}

	@Override
	public String removeSpaces(String userName) {
		String newUserName = userName;
	
		while(newUserName.contains(" ")) {
			System.out.println("\nUsername cannot contain spaces.");
			System.out.print("Enter username: ");
			newUserName = Driver.read.nextLine();
		}
		
		return newUserName;
		
	}
	
	@Override
	public boolean userExists(String userName) {
		for(User u : Driver.userList) {
			if(userName.equals(u.getUserName())) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public boolean isPasswordCorrect(User user, String pw) {
		if(user.getPw().equals(pw)) {
			return true;
		}

		return false;
	}

	@Override
	public User promptLogin() {
		String userName = "", pw = "";
		User user = null;

		System.out.println("\n===== Login =====\n");
		System.out.print("Username: ");
		userName = Driver.read.nextLine();
		userName = removeSpaces(userName);
		
		// if user exists, check for verification
		if(userExists(userName)) {
		
			// match correct user
			for(User u : Driver.userList) {
				if(userName.equals(u.getUserName())) {
					user = u;
				}
			}
		
			System.out.print("Password: ");
			pw = Driver.read.nextLine();
			System.out.println();
			
			if(isPasswordCorrect(user, pw)) {
				return user;
			}
			
			else {
				System.out.println("Wrong password!");
				return null;
			}
		}
		
		else {
			System.out.println("Username " + userName + " does not exist!");
			return null;
		}

	}
	
	@Override
	public void saveUser(User user, String userName, String pw, String type) {
		user.setUserName(userName);
		user.setPw(pw);
		user.setType(type);
		Driver.userList.add(user);
		Driver.serialUser.writeUserList(Driver.userList);
		
		System.out.println("\nCustomer " + userName + " successfully created.");
	
	}

	@Override
	public Customer createCustomer() {
		String userName, pw;
		User newCustomer = new Customer();
		
		System.out.println("\n===== Create new customer account =====\n");
		System.out.print("Enter username: ");
		userName = Driver.read.nextLine();
		userName = removeSpaces(userName);

		// if user is not taken, create an account
		if(!(userExists(userName))) {
			System.out.print("Enter password: ");
			pw = Driver.read.nextLine();

			// save customer to file
			saveUser(newCustomer, userName, pw, "Customer");
			
			return (Customer) newCustomer;
		}
		
		else {
			System.out.println("User " + userName + " already exists!");
			return null;
		}
		
	}

	@Override
	public Employee createEmployee() {
		String userName, pw;
		User newEmployee = new Employee();
		
		System.out.println("\n===== Create new emplpoyee account =====\n");
		System.out.print("Enter username: ");
		userName = Driver.read.nextLine();
		userName = removeSpaces(userName);

		// if user is not taken, create an account
		if(!(userExists(userName))) {
			System.out.print("Enter password: ");
			pw = Driver.read.nextLine();
			
			// save employee to file
			saveUser(newEmployee, userName, pw, "Employee");
			
			return (Employee) newEmployee;
		}
		
		else {
			System.out.println("User " + userName + " already exists!");
			return null;
		}

	}

	@Override
	public Admin createAdmin() {
		String userName, pw;
		User newAdmin = new Admin();
		
		System.out.println("\n===== Create new admin account =====\n");
		System.out.print("Enter username: ");
		userName = Driver.read.nextLine();
		userName = removeSpaces(userName);

		// if user is not taken, create an account
		if(!(userExists(userName))) {
			System.out.print("Enter password: ");
			pw = Driver.read.nextLine();
			
			// save admin to file
			saveUser(newAdmin, userName, pw, "Admin");
			
			return (Admin) newAdmin;
		}
		
		else {
			System.out.println("User " + userName + " already exists!");
			return null;
		}
		
	}

	@Override
	public User prompt() {
		int code = 0;
		User user = null;
	
		code = promptWelcome();
		switch(code) {
			case 0:
				user = promptLogin();
				break;
			case 1:
				user = createCustomer();
				break;
			case 2:
				user = createEmployee();
				break;
			case 3:
				user = createAdmin();
				break;
			default:
				break;
		}

		return user;
	}

}