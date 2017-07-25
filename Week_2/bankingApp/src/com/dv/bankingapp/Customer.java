package com.dv.bankingapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends User {

	private float balance = 0.0f;
	private int status = 0;
	ApplicationRequest request = null;
	
	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
		sql = "SELECT Status "
				+ "FROM Customers "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		rs = pStmt.executeQuery();
		rs.next();

		// check the customers current status
		switch(rs.getInt(1)) {
			case 0:	
				System.out.println("ATTENTION: You have not yet applied for an account.");
				break;
			case 1:	
				System.out.println("Application pending.");
				break;
			case 2:		
				System.out.println("Application denied.");
				break;
			case 3:		
				System.out.println("Application verified.");
				break;
			default:
				System.out.println("WARNING: Unknown application status!");
				break;
		}
		
	}
	
	/* getApplicationStatus
	 * search the database for the customers current application status
	 */
	public int getApplicationStatus(String userName) throws SQLException {
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		sql = "SELECT Status "
				+ "FROM Customers "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		return rs.getInt(1);
	}

	/* apply
	 * fill a request and change status to pending
	 */
	public void apply() throws SQLException {
		int cid = 0;
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		// get the status from the database
		String userName = Driver.authUser.getUserName();
		int status = getApplicationStatus(userName);
	
		switch(status) {
			case 0:
				// create a filled customer application request
				request = new ApplicationRequest();
				request.setUserName(userName);
				((Customer) Driver.authUser).setStatus(1);
				
				// update customer status in the customers table
				sql = "UPDATE Customers "
						+ "SET Status=1 "
						+ "WHERE Username=?";
				
				pStmt = Driver.conn.prepareStatement(sql);
				pStmt.setString(1, userName);
				
				pStmt.executeUpdate();	
				pStmt.close();
				
				// get the customers uid to put in the application requests table
				sql = "SELECT C_ID "
						+ "FROM Customers "
						+ "WHERE Username=?";
				
				pStmt = Driver.conn.prepareStatement(sql);
				pStmt.setString(1, userName);
				
				rs = pStmt.executeQuery();
				rs.next();
				
				cid = rs.getInt(1);
				pStmt.close();
				
				// send the filled application to the database in the applicationrequests table
				sql = "INSERT INTO ApplicationRequests "
						+ "(C_ID, C_Username) "
						+ "VALUES (?, ?)";
				
				pStmt = Driver.conn.prepareStatement(sql);
				pStmt.setInt(1, cid);
				pStmt.setString(2, userName);
				
				pStmt.executeUpdate();
				pStmt.close();
				
				System.out.println("You have submitted an application.");
				break;
			case 1:
				System.out.println("You already have submitted a request!");
				break;
			
			/* Not having a case for 2 allows Customer to re-apply after a denied request
			case 2:
				System.out.println("Your application has been denied.");
				break;
			*/

			case 3:
				System.out.println("Your application has already been approved.");
				break;
			default:
				System.out.println("Your application was lost in the process.");
				break;
		}
		
	}
	
	/* getBalance
	 * query the database for the customer's balance
	 */
	public float selectBalance() throws SQLException {
		String userName = Driver.authUser.getUserName();
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		sql = "SELECT Balance "
				+ "FROM Customers "
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setString(1, userName);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		return rs.getFloat(1);
	}
	 
	 /* viewBalance
	  * view the current balance
	  */
	public void viewBalance() throws SQLException {
		System.out.println("\n===== Your Account Balance =====");
		System.out.println("$" + selectBalance());
	}
	
	/* getFloat
	 * return a float value
	 */
	public float getFloat() {
		float value = 0.0f;
		boolean loop = true;

		while(loop) {
			try {
				value = Float.parseFloat(Driver.read.nextLine());
				loop = false;
			}
			
			catch (NumberFormatException e) {
				System.out.println("Amount entered was not a valid.");
				System.out.print("Enter a value: ");
			}
		}
		
		return value;
	}
	
	/* updateDeposit
	 * deposit given amount and update the database
	 */
	public void updateDeposit(float currBalance, float amount) throws SQLException {
		String userName = Driver.authUser.getUserName();
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		float newBalance = 0.0f;
		
		// get the current balance and set the new balance
		newBalance = currBalance + amount;
		
		sql = "UPDATE Customers "
				+ "SET Balance=?"
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setFloat(1, newBalance);
		pStmt.setString(2, userName);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		pStmt.close();
		rs.close();
	}

	/* updateWithdraw
	 * withdraw given amount and update the database
	 */
	public void updateWithdraw(float currBalance, float amount) throws SQLException {
		String userName = Driver.authUser.getUserName();
		String sql = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		float newBalance = 0.0f;
		
		// get the current balance and set the new balance
		newBalance = currBalance - amount;
		
		sql = "UPDATE Customers "
				+ "SET Balance=?"
				+ "WHERE Username=?";
		
		pStmt = Driver.conn.prepareStatement(sql);
		pStmt.setFloat(1, newBalance);
		pStmt.setString(2, userName);
		
		rs = pStmt.executeQuery();
		rs.next();
		
		pStmt.close();
		rs.close();
	}
	  
	 /* deposit
	  * deposit money into your account
	  */
	public void deposit() throws SQLException {
		float currBalance, amount = 0.0f;
		
		// get the current balance from the database
		currBalance = selectBalance();
	
		System.out.println("\n===== Deposit =====");
		System.out.println("Here is your current balance: $" + currBalance);
		System.out.println("How much money would you like to deposit?");
		System.out.print("$ ");
		
		amount = getFloat();
		
		if(amount > 0) { 
			
			// update customer's balance in the database
			updateDeposit(currBalance, amount);
			System.out.println("You successfully deposited $" + amount + ".");
		}
		
		else {
			System.out.println("You must deposit a positive value!");
		}
	}
	   
	 /* withdraw
	  * withdraw money out of your account
	  */
	public void withdraw() throws SQLException {
		float currBalance, amount = 0.0f;
		
		// get the current balance from the database
		currBalance = selectBalance();
	
		System.out.println("\n===== Withdraw =====");
		System.out.println("Here is your current balance: $" + currBalance);
		System.out.println("How much money would you like to withdraw?");
		System.out.print("$ ");
		
		amount = getFloat();
		
		if(amount <= currBalance) {
			
			// update customer's balance in the database
			updateWithdraw(currBalance, amount);
			System.out.println("You successfully withdrew $" + amount + ".");
		
		}
		
		else {
			System.out.println("You don't have enough money to withdraw $" + amount + "!");
		}

	}

}
