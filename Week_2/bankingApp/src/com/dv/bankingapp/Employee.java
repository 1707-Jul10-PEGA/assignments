package com.dv.bankingapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee extends User {
	
	private Customer customer = null;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
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
		rs.next();

		System.out.println("\n===== Account Information =====");
		System.out.println("Account type: " + rs.getString(3));
		System.out.println("Username: " + rs.getString(1));
		System.out.println("Password: " + rs.getString(2));
		
		pStmt.close();
		rs.close();
	}

	@Override
	public void viewAccount() throws SQLException {
		String userName = Driver.authUser.getUserName();
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		viewUserInfo();

		// view user specific info
		sql = "SELECT C_Username "
				+ "FROM Employees "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		if(rs.getString(1) == null) {
			System.out.println("No customer associated.");
		}
		
		else {
			System.out.println("\n===== Assigned Customer =====");
			System.out.println("Customer: " + rs.getString(1));
		}
	}
	
	/* viewApplications
	 * view all the pending applications in the database
	 */
	public void viewApplications() throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		sql = "SELECT C_Username "
				+ "FROM ApplicationRequests";
		
		pStmt = Driver.conn.prepareStatement(sql);
		
		rs = pStmt.executeQuery();
		
		while(rs.next()) {
			System.out.println("\n===== Application Request =====");
			System.out.println(rs.getString(1));
		}
	}
	
	/* updateCustomerStatus
	 * set the status for the customer
	 */
	public void updateCustomerStatus(String customerName, int status) throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		
		sql = "UPDATE Customers "
				+ "SET Status=? "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setInt(1, status);
		pStmt.setString(2, customerName);
		
		pStmt.executeUpdate();
		
	}
	
	/* updateEmployeeCustomer
	 * update the associated customer for the employee
	 */
	public void updateEmployeeCustomer(String customerName) throws SQLException {
		String userName = Driver.authUser.getUserName();
		String sql = null;
		PreparedStatement pStmt = null;
		
		sql = "UPDATE Employees "
				+ "SET C_Username=? "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, customerName);
		pStmt.setString(2, userName);
		
		pStmt.executeUpdate();
	}
	
	/* selectCustomerName
	 * select the existing associated customer
	 */
	public String selectExistingCustomer() throws SQLException {
		String userName = Driver.authUser.getUserName();
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		sql = "SELECT C_Username "
				+ "FROM Employees "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		return rs.getString(1);
	}
	
	/* applicationsExist
	 * returns true if there are pending applications within the database
	 */
	public boolean applicationsExist() throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		sql = "SELECT C_Username "
				+ "FROM ApplicationRequests";
		
		pStmt = Driver.conn.prepareStatement(sql);
		
		rs = pStmt.executeQuery();
	
		if(rs.next()) {
			return true;
		}

		return false;
	}
	
	/* selectMaxAID
	 * returns the top application id to approve
	 */
	public int selectTopApplication() throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		sql = "SELECT MAX(A_ID) "
				+ "FROM ApplicationRequests";
		
		pStmt = Driver.conn.prepareStatement(sql);
		rs = pStmt.executeQuery();
		rs.next();
		
		return rs.getInt(1);
	}
	
	/* selectAssociatedCustomer
	 * returns the customer at the top of the application list as the associated customer
	 */
	public String selectAssociatedCustomer(int maxAID) throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		sql = "SELECT C_Username "
				+ "FROM ApplicationRequests "
				+ "WHERE A_ID=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setInt(1, maxAID);

		rs = pStmt.executeQuery();
		rs.next();
		
		return rs.getString(1);
	}
	
	/* deleteApplicationRequest
	 * delete the application request for the newly associated customer
	 */
	public void deleteApplicationRequest(String associatedCustomer) throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		
		sql = "DELETE FROM ApplicationRequests "
				+ "WHERE C_Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, associatedCustomer);

		pStmt.executeUpdate();
	}

	/* approveApp
	 * approve an application for a customer
	 */
	public void approveApp() throws SQLException {
		int topAppId = 0;
		String associatedCustomer = null;
		String existingCustomer = selectExistingCustomer();
		
		if(existingCustomer != null) {
			System.out.println("\nYou can only be assigned one customer.");
		}
		
		else if (!applicationsExist()){
			System.out.println("\nThere are no applications to approve at this time.");
		}
		
		else {
			
			// grab the top pending application
			topAppId = selectTopApplication();
			
			// retrieve c_username of maxAID
			associatedCustomer = selectAssociatedCustomer(topAppId);
			System.out.println("\nAssociating customer " + associatedCustomer + " to you ...");
			
			// update customer status in customers
			updateCustomerStatus(associatedCustomer, 3);
			
			// update employee associated customer in employees
			updateEmployeeCustomer(associatedCustomer);
			System.out.println("\nYour new customer is " + associatedCustomer + "!");
			
			// delete max aid row
			deleteApplicationRequest(associatedCustomer);
		}
	}
	
	/* selectCustomerBalance
	 * view the balance in the database for the associated customer
	 */
	public void selectCustomerBalance() throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		String associatedCustomer = selectExistingCustomer();

		if(associatedCustomer == null) {
			System.out.println("\nNo customer associated.");
		}
		
		else {
			sql = "SELECT Balance "
					+ "FROM Customers "
					+ "WHERE Username=?";
			
			pStmt = Driver.conn.prepareStatement(sql);
			pStmt.setString(1, associatedCustomer);

			rs = pStmt.executeQuery();
			rs.next();
			
			System.out.println("\n===== Customer Balance =====");
			System.out.println("Username: " + associatedCustomer);
			System.out.println("Balance: " + rs.getFloat(1));
		}
	}
	 
	 /* denyApp
	  * deny an application for a customer
	  */
	public void denyApp() throws SQLException {
		int topAppId = 0;
		String associatedCustomer = null;
	
		if(!applicationsExist()) {
			System.out.println("\nThere are no applications to deny at this time.");
		}
		
		else {

			// grab the top pending application
			topAppId = selectTopApplication();
			
			// retrieve the customer name of the top application
			associatedCustomer = selectAssociatedCustomer(topAppId);
			System.out.println("\nDenying application for customer " + associatedCustomer + " ...");
			
			// deny customer application request
			updateCustomerStatus(associatedCustomer, 0);
			
			// delete the application request for the denied customer
			deleteApplicationRequest(associatedCustomer);
		}
	}
	
}