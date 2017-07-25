package com.dv.bankingapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public boolean hasSpaces(String userName) {
		if(userName.contains(" ")) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean hasTooManyCharacters(String userName) {
		if(userName.length() > 10) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean userExists(String userName) {
		String sql = "SELECT Username FROM Users WHERE Username=?";
		
		try (PreparedStatement pStmt = Driver.conn.prepareStatement(sql)){
			pStmt.setString(1, userName);
			
			try(ResultSet rs = pStmt.executeQuery()) {
				
				// if the result set returns something, check if result matches the username
				if(rs.next()) {
					if(rs.getString(1).equals(userName)) {
						return true;
					}
				}
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@Override
	public boolean isPasswordCorrect(int uid, String pw) throws SQLException {
		ResultSet rs = null;
		String sql = "SELECT Password "
						+ " FROM Users "
						+ " WHERE U_ID=?";
		PreparedStatement pStmt = Driver.conn.prepareStatement(sql);
		
		pStmt.setInt(1, uid);
		
		// point to the result set of the sql query above
		rs = pStmt.executeQuery();
		rs.next();
		
		if(rs.getString(1).equals(pw)) {
			return true;
		}
		
		return false;
	}

	@Override
	public int getUserID(String userName) throws SQLException {
		ResultSet rs = null;
		String sql = "SELECT U_ID "
						+ "FROM Users "
						+ "WHERE Username=?"; 

		PreparedStatement pStmt = Driver.conn.prepareStatement(sql);
		
		pStmt.setString(1, userName);

		// point to the result set of the sql query above
		rs = pStmt.executeQuery();
		rs.next();
		
		// return u_id
		return rs.getInt(1);
	}
	
	@Override
	public String getUserType(int uid) throws SQLException {
		String sql = "SELECT Type "
						+ "FROM Users "
						+ "WHERE U_ID=?";
		ResultSet rs = null;
		
		PreparedStatement pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setInt(1, uid);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		return rs.getString(1);
	}

	@Override
	public void authenticateCustomer(int uid) throws SQLException {
		String sql = null;
		ResultSet rs = null;
		Customer authCustomer = new Customer();
		
		// get all info from the users table
		sql = "SELECT Username, Password "
				+ "FROM Users "
				+ "WHERE U_ID=?";
		
		PreparedStatement pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setInt(1, uid);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		authCustomer.setUserName(rs.getString(1));
		authCustomer.setPw(rs.getString(2));
		authCustomer.setType("Customer");
		
		// get all info from the customers table
		sql = "SELECT Balance, Status "
				+ "FROM Customers "
				+ "WHERE C_ID=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setInt(1, uid);
		
		rs = pStmt.executeQuery();	
		rs.next();

		authCustomer.setBalance(rs.getFloat(1));
		authCustomer.setStatus(rs.getInt(2));
		
		// set the authenticated user to this customer
		Driver.authUser = authCustomer;
	}

	@Override
	public void authenticateEmployee(int uid) throws SQLException {
		String sql = null;
		ResultSet rs = null;
		Employee authEmployee = new Employee();
		Customer associatedCustomer = null;
		
		// get all info from the users table
		sql = "SELECT Username, Password "
				+ "FROM Users "
				+ "WHERE U_ID=?";
		
		PreparedStatement pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setInt(1, uid);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		authEmployee.setUserName(rs.getString(1));
		authEmployee.setPw(rs.getString(2));
		authEmployee.setType("Employee");
		
		// get all info from the employees table
		sql = "SELECT C_Username "
				+ "FROM Employees "
				+ "WHERE E_ID=?";
		
		pStmt.close();
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setInt(1, uid);
		
		rs = pStmt.executeQuery();	
		rs.next();

		// get associated customer information if they exist
		if((associatedCustomer = authEmployee.getCustomer()) != null) {
			sql = "SELECT Username "
					+ "FROM Employees "
					+ "WHERE Username=?";
			
			pStmt.close();
			pStmt = Driver.conn.prepareStatement(sql);
			pStmt.setString(1, associatedCustomer.getUserName());
			
			rs = pStmt.executeQuery();
			rs.next();

			authEmployee.setCustomer(associatedCustomer);
		}
		
		// set the authenticated user to this customer
		Driver.authUser = authEmployee;
	}

	@Override
	public void authenticateAdmin(int uid) throws SQLException {
		String sql = null;
		ResultSet rs = null;
		Admin authAdmin = new Admin();
		
		// get all info from the users table
		sql = "SELECT Username, Password "
				+ "FROM Users "
				+ "WHERE U_ID=?";
		
		PreparedStatement pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setInt(1, uid);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		authAdmin.setUserName(rs.getString(1));
		authAdmin.setPw(rs.getString(2));
		authAdmin.setType("Admin");
		
		Driver.authUser = authAdmin;
	}
	
	@Override
	public void setAuthUser(int uid) throws SQLException {
		String userType = null;
		
		/* need type of user first, then instantiate */
		userType = getUserType(uid);
		
		/* fill out user fields, then set the authenticated user based on type */
		switch(userType) {
			case "Customer":
				authenticateCustomer(uid);
				break;
			case "Employee":
				authenticateEmployee(uid);
				break;
			case "Admin":
				authenticateAdmin(uid);
				break;
			default:
				System.out.println("Error: Unknown user type.");
				break;
		}
	}

	@Override
	public void promptLogin() {
		String userName = "", pw = "";
		int uid = 0;

		System.out.println("\n===== Login =====\n");
		System.out.print("Username: ");
		userName = Driver.read.nextLine();
		
		while(hasSpaces(userName) || hasTooManyCharacters(userName)) {
			System.out.println("\nUsername cannot contain spaces and must be less than 10 characters.");
			System.out.print("Enter username: ");
			userName = Driver.read.nextLine();
		}
		
		// if user exists in the database, check for verification
		if(userExists(userName)) {
			
			try {
				uid = getUserID(userName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.print("Password: ");
			pw = Driver.read.nextLine();
			System.out.println();
			
			try {
				if(isPasswordCorrect(uid, pw)) {
					setAuthUser(uid);
				}
				
				else {
					System.out.println("Wrong password!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else {
			System.out.println("Username " + userName + " does not exist!");
		}

	}

	@Override
	public int insertUser(User user) throws SQLException {
		String sql = "INSERT INTO Users "
						+ "(Username, Password, Type) "
						+ " VALUES (?, ?, ?)";
		
		PreparedStatement pStmt = Driver.conn.prepareStatement(sql);
		
		pStmt.setString(1, user.getUserName());
		pStmt.setString(2, user.getPw());
		pStmt.setString(3, user.getType());
		
		return pStmt.executeUpdate();
	}

	@Override
	public int insertCustomer(Customer customer) throws SQLException {
		String sql = "INSERT INTO Customers "
						+ "(Username, Balance, Status) "
						+ " VALUES (?, ?, ?)";
		
		PreparedStatement pStmt = Driver.conn.prepareStatement(sql);
		
		pStmt.setString(1, customer.getUserName());
		pStmt.setFloat(2, customer.getBalance());
		pStmt.setInt(3, customer.getStatus());

		return pStmt.executeUpdate();
	}
	
	@Override
	public int insertEmployee(Employee employee) throws SQLException {
		String sql = "INSERT INTO Employees "
						+ "(Username, C_Username) "
						+ " VALUES (?, ?)";
		String customerName = null;
		
		PreparedStatement pStmt = Driver.conn.prepareStatement(sql);
		
		pStmt.setString(1, employee.getUserName());
		
		if(employee.getCustomer() != null) {
			customerName = employee.getCustomer().getUserName();
			pStmt.setString(2, customerName);
		}
		
		if(employee.getCustomer() == null) {
			pStmt.setString(2, null);
		}
		

		return pStmt.executeUpdate();
	}

	@Override
	public void createCustomer() {
		String userName, pw;
		Customer newCustomer = new Customer();
		
		System.out.println("\n===== Create new customer account =====\n");
		System.out.print("Enter username: ");
		userName = Driver.read.nextLine();

		while(hasSpaces(userName) || hasTooManyCharacters(userName)) {
			System.out.println("\nUsername cannot contain spaces and must be less than 10 characters.");
			System.out.print("Enter username: ");
			userName = Driver.read.nextLine();
		}

		// if user is not taken, create an account
		if(!(userExists(userName))) {
			System.out.print("Enter password: ");
			pw = Driver.read.nextLine();
			
			// fill in customer fields 
			newCustomer.setUserName(userName);
			newCustomer.setPw(pw);
			newCustomer.setType("Customer");
			newCustomer.setBalance(0.0f);
			newCustomer.setStatus(0);
			
			// insert customer into users table
			try {
				insertUser(newCustomer);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// insert customer into customers table
			try {
				insertCustomer(newCustomer);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// set the current user to the newly created customer
			Driver.authUser = newCustomer;
		}
		
		else {
			System.out.println("User " + userName + " already exists!");
		}
		
	}

	@Override
	public void createEmployee() {
		String userName, pw;
		Employee newEmployee = new Employee();
		
		System.out.println("\n===== Create new emplpoyee account =====\n");
		System.out.print("Enter username: ");
		userName = Driver.read.nextLine();

		while(hasSpaces(userName) || hasTooManyCharacters(userName)) {
			System.out.println("\nUsername cannot contain spaces and must be less than 10 characters.");
			System.out.print("Enter username: ");
			userName = Driver.read.nextLine();
		}

		// if user is not taken, create an account
		if(!(userExists(userName))) {
			System.out.print("Enter password: ");
			pw = Driver.read.nextLine();
			
			// fill in employee fields
			newEmployee.setUserName(userName);
			newEmployee.setPw(pw);
			newEmployee.setType("Employee");
			newEmployee.setCustomer(null);
			
			// insert employee into users table
			try {
				insertUser(newEmployee);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// insert employee into employees table
			try {
				insertEmployee(newEmployee);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// set the current user to the newly created employee
			Driver.authUser = newEmployee;
		}
		
		else {
			System.out.println("User " + userName + " already exists!");
		}

	}

	@Override
	public void createAdmin() {
		String userName, pw;
		Admin newAdmin = new Admin();
		
		System.out.println("\n===== Create new admin account =====\n");
		System.out.print("Enter username: ");
		userName = Driver.read.nextLine();

		while(hasSpaces(userName) || hasTooManyCharacters(userName)) {
			System.out.println("\nUsername cannot contain spaces and must be less than 10 characters.");
			System.out.print("Enter username: ");
			userName = Driver.read.nextLine();
		}

		// if user is not taken, create an account
		if(!(userExists(userName))) {
			System.out.print("Enter password: ");
			pw = Driver.read.nextLine();
			
			// fill in admin fields
			newAdmin.setUserName(userName);
			newAdmin.setPw(pw);
			newAdmin.setType("Admin");
			
			// insert admin into users table
			try {
				insertUser(newAdmin);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// set the current user to the newly created admin
			Driver.authUser = newAdmin;
		}
		
		else {
			System.out.println("User " + userName + " already exists!");
		}
		
	}

	@Override
	public void prompt() {
		int code = 0;
	
		code = promptWelcome();
		switch(code) {
			case 0:
				promptLogin();
				break;
			case 1:
				createCustomer();
				break;
			case 2:
				createEmployee();
				break;
			case 3:
				createAdmin();
				break;
			default:
				break;
		}
	}

}