package com.dv.bankingapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin extends User {

	public void viewUserInfo() throws SQLException {
		String userName = Driver.authUser.getUserName();
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		// query the database for the correct user
		sql = "SELECT Username, Password, Type "
				+ "FROM Users "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		rs = pStmt.executeQuery();
		
		
		if(rs.next()) {
			System.out.println("\n===== Account Information =====");
			System.out.println("Account type: " + rs.getString(3));
			System.out.println("Username: " + rs.getString(1));
			System.out.println("Password: " + rs.getString(2));
		}
		
		else {
			System.out.println("You no longer exist in the database!");
		}
		
		pStmt.close();
		rs.close();
	}
	
	@Override
	public void viewAccount() throws SQLException {
		viewUserInfo();
	}
	
	/* viewAllAccounts
	 * view all accounts in the system
	 */
	public void viewAllAccounts() throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		// query the database for all users
		sql = "SELECT Username, Password, Type "
				+ "FROM Users ";
		
		pStmt = Driver.conn.prepareStatement(sql);
		
		rs = pStmt.executeQuery();
		
		System.out.println("\n===== All users =====");
		while(rs.next()) {
			System.out.println("Type: " + rs.getString(3));
			System.out.println("Username: " + rs.getString(1));
			System.out.println("Password: " + rs.getString(2));
			System.out.println();
		}
	}
	
	/* userExists
	 * return true if user exists within the database
	 */
	public boolean userExists(String userName) throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		sql = "SELECT Username "
				+ "FROM Users "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		rs = pStmt.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		
		return false;
	}
	
	/* printUserInfo
	 * print all the information about the user
	 */
	public void printUserInfo(String userName) throws SQLException {
		String sql, type = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		// get user and type
		sql = "SELECT Username, Password, Type "
				+ "FROM Users "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		type = rs.getString(3);
		
		System.out.println("\n===== User Account Information =====");
		System.out.println("Account Type: " + type);
		System.out.println("Username: " + rs.getString(1));
		System.out.println("Password: " + rs.getString(2));
		
		pStmt.close();
		rs.close();
		
		if(type.equals("Customer")) {
			
			// get specific customer info
			sql = "SELECT Balance, Status "
					+ "FROM Customers "
					+ "WHERE Username=?";
			
			pStmt = Driver.conn.prepareStatement(sql);
			pStmt.setString(1, userName);
			
			rs = pStmt.executeQuery();
			rs.next();
			
			switch(rs.getInt(2)) {
				case 0:
					System.out.println("Status: Not yet applied");
					break;
				case 1:
					System.out.println("Status: Pending");
					break;
				case 2:
					System.out.println("Status: Denied");
					break;
				case 3:
					System.out.println("Status: Verified");
					break;
				default:
					System.out.println("Status: Unknown");
					break;
			}

			System.out.println("Balance: $" + rs.getFloat(1));
		}
		
		else if(type.equals("Employee")) {
			
			// get specific employee info
			sql = "SELECT C_Username "
					+ "FROM Employees "
					+ "WHERE Username=?";
			
			pStmt.close();
			rs.close();

			pStmt = Driver.conn.prepareStatement(sql);
			pStmt.setString(1, userName);
			
			rs = pStmt.executeQuery();
			rs.next();
			
			if(rs.getString(1) == null) {
				System.out.println("No customer associated.");
			}
			
			else {
				System.out.println("Customer: " + rs.getString(1));
			}
		}
	}

	/* viewUserAccount
	 * edit the account of a user
	 */
	public void viewUserAccount() throws SQLException {
		String userName = null;
	
		viewAllAccounts();
		
		// enter userName of account
		System.out.print("Enter name of user to edit: ");
		userName = Driver.read.nextLine();
		
		// check if user exists and query their info
		if(userExists(userName)) {

			// query all user info
			printUserInfo(userName);
			
		}
		
		else {
			System.out.println("User " + userName + " not found!");
		}
	}
	
	/* deleteAssociatedCustomer
	 * if an employee has an associated customer, delete them
	 */
	public void deleteAssociatedCustomer(String customerName) throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		
		sql = "UPDATE Employees "
				+ "SET C_Username=? "
				+ "WHERE C_Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, null);
		pStmt.setString(2, customerName);
		
		pStmt.executeQuery();
	}

	/* deleteApplicationRequest
	 * delete the application request for the customer
	 */
	public void deleteApplicationRequest(String customerName) throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		
		sql = "DELETE FROM ApplicationRequests "
				+ "WHERE C_Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, customerName);

		pStmt.executeUpdate();
	}
	
	/* deleteUser
	 * delete the specified user from users.txt
	 */
	public void deleteUser(String userName) throws SQLException {
		String sql, type = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		// get user and type
		sql = "SELECT Username, Password, Type "
				+ "FROM Users "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		type = rs.getString(3);

		// check what type of user is being deleted
		if(type.equals("Customer")) {
			
			// check the employee table if they are associated with a customer, if so, set associated customer to null
			deleteAssociatedCustomer(userName);
			
			// check application requests if this customer has a request, if so, delete their request
			deleteApplicationRequest(userName);
			
			// delete the customer from the customers table
			pStmt.close();
			
			sql = "DELETE FROM Customers "
					+ "WHERE Username=?";

			pStmt = Driver.conn.prepareStatement(sql);
			pStmt.setString(1, userName);
			
			pStmt.executeUpdate();
		}
		
		// if user type is an employee, remove the employee from the employees table
		else if(type.equals("Employee")) {
			pStmt.close();
			sql = "DELETE FROM Employees "
					+ "WHERE Username=?";

			pStmt = Driver.conn.prepareStatement(sql);
			pStmt.setString(1, userName);
			
			pStmt.executeUpdate();
		}
		
		// finally, delete the user from the users table
		pStmt.close();
		
		sql = "DELETE FROM Users "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		pStmt.executeUpdate();
		
		System.out.println("Successfully deleted user " + userName);
	}
	
	/* deleteUserAccount
	 * delete the account of a user
	 */
	public void deleteUserAccount() throws SQLException {
		String userName = null;
		
		viewAllAccounts();
		
		// enter userName of account
		System.out.print("Enter name of user to delete: ");
		userName = Driver.read.nextLine();
		
		// if user exists, delete the user account
		if(userExists(userName)) {
			deleteUser(userName);
		}
		
		else {
			System.out.println("User " + userName + " does not exist!");
		}
	}
	
}