package com.WilliamLewis.BankingApp.JDBC.DoAs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.JDBC.Connection.ConnectionFactory;
import com.WilliamLewis.BankingApp.Users.User;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

public class AccountImplementDOA {
	private static AccountImplementDOA accountDOA = null;
	private static Boolean build = true;
	Connection conn = null;
	private static Logger log = Logger.getRootLogger();
	private AccountImplementDOA(){
		
	}
	
	public static synchronized AccountImplementDOA getInstance(){
		if(build){
			accountDOA = new AccountImplementDOA();
		}
		return accountDOA;
	}
	public void setup(){
		log.debug("Attempting to use ConnectionFactory");
		conn = ConnectionFactory.getInstance().getConnection();
		
	}
	public void end(){
		try {
			conn.close();
		} catch (SQLException e) {
			log.debug( "AHHH COULDN'T CLOSE IT SCOTTY");
			e.printStackTrace();
		}
	}
	

	public boolean createAccount(Account acc, int userId, int manageId) throws SQLException {
		//Correct means of injecting
		setup();
		conn.setAutoCommit(false);
		Boolean norolled = true;
		
		String sql = "insert into account(AccountID, Balance, UserIDHolder, UserIDManager, Status"
				+ ") values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, acc.getAccountNumber());
		pstmt.setDouble(2, acc.getAccountBalance());
		pstmt.setInt(3, userId);
		pstmt.setInt(4, manageId);
		pstmt.setInt(5, 1);
		
		Savepoint s = conn.setSavepoint();
		
		int num = pstmt.executeUpdate();
		
		
		if (num > 1){
			
			conn.rollback(s);
			norolled = false;
		}
		conn.commit();
		
		conn.setAutoCommit(true);
		end();
		return norolled;
	}


	public void updateAccountBalance(Account acc) throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		
		String sql = "UPDATE Account SET Balance = ? WHERE ACCOUNTID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setDouble(1, acc.getAccountBalance());
		pstmt.setInt(2, acc.getAccountNumber());

		Savepoint s = conn.setSavepoint();
		
		int num = pstmt.executeUpdate();

		
		
		if (num > 1){
			
			conn.rollback(s);
		}
		conn.commit();
		
		conn.setAutoCommit(true);
		end();
		return;

	}
	public void approveAccount(Account acc) throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		
		String sql = "UPDATE Account SET Status = 2 WHERE ACCOUNTID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, acc.getAccountNumber());

		Savepoint s = conn.setSavepoint();
		
		int num = pstmt.executeUpdate();

		if (num > 1){
			
			conn.rollback(s);
		}
		conn.commit();
		
		conn.setAutoCommit(true);
		end();
		return;

	}
	public void denyAccount(Account acc) throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		
		String sql = "DELETE * FROM Account Where ACCOUNTID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, acc.getAccountNumber());

		Savepoint s = conn.setSavepoint();
		
		int num = pstmt.executeUpdate();

		if (num > 1){
			
			conn.rollback(s);
		}
		conn.commit();
		
		conn.setAutoCommit(true);
		end();
		return;

	}

	public ArrayList<Account> getAllAccounts() throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		ArrayList<Account> myAccs = new ArrayList<Account>();
		
		String sql = "SELECT * FROM ACCOUNT";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeQuery();
		ResultSet rs = pstmt.getResultSet();
		Account myAcc = null;
		while(rs.next())
		{
		myAcc = new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
		myAccs.add(myAcc);
		}
		
		conn.setAutoCommit(true);
		end();
		return myAccs;
	}
	public ArrayList<Account> getAllActiveAccounts() throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		ArrayList<Account> myAccs = new ArrayList<Account>();
		
		String sql = "SELECT * FROM ACCOUNT Where Status = 2";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeQuery();
		ResultSet rs = pstmt.getResultSet();
		Account myAcc = null;
		while(rs.next())
		{
		myAcc = new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
		myAccs.add(myAcc);
		}
		
		conn.setAutoCommit(true);
		end();
		return myAccs;
	}
	public ArrayList<Account> getAllPendingAccounts() throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		ArrayList<Account> myAccs = new ArrayList<Account>();
		
		String sql = "SELECT * FROM ACCOUNT Where Status = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeQuery();
		ResultSet rs = pstmt.getResultSet();
		Account myAcc = null;
		while(rs.next())
		{
		myAcc = new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
		myAccs.add(myAcc);
		}
		
		conn.setAutoCommit(true);
		end();
		return myAccs;
	}
	public ArrayList<Account> getAccountsToManage(Integer EmployeeID) throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		ArrayList<Account> myAccs = new ArrayList<Account>();
		
		String sql = "SELECT * FROM ACCOUNT WHERE UserIDManager = ? AND Status = 2;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, EmployeeID);

		pstmt.executeQuery();
		ResultSet rs = pstmt.getResultSet();
		Account myAcc = null;
		while(rs.next())
		{
		myAcc = new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
		myAccs.add(myAcc);
		}	
		end();
		return myAccs;
		
	}

	public ArrayList<Account> getPendingApplications() throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		ArrayList<Account> myAccs = new ArrayList<Account>();
		
		String sql = "SELECT * FROM ACCOUNT WHERE Status = 1;";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.executeQuery();
		
		ResultSet rs = pstmt.getResultSet();
		Account myAcc = null;
		while(rs.next())
		{
		myAcc = new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
		myAccs.add(myAcc);
		}	
		conn.setAutoCommit(true);
		end();
		return myAccs;
	}
	public ArrayList<Account> getPendingApplicationsOnEmpID(User user) throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		ArrayList<Account> myAccs = new ArrayList<Account>();
		
		String sql = "SELECT * FROM ACCOUNT WHERE Status = 1 AND UserIDManager = ?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user.getUserID());

		pstmt.executeQuery();
		
		ResultSet rs = pstmt.getResultSet();
		Account myAcc = null;
		while(rs.next())
		{
		myAcc = new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
		myAccs.add(myAcc);
		}	
		conn.setAutoCommit(true);
		end();
		return myAccs;
	}
	public Integer leastBurdenedEmployee() throws SQLException{
		setup();
		conn.setAutoCommit(false);
		//TODO find the Employee whose ID occures least in the Account table
		// SELECT UserIDManager FROM ACCOUNT WHERE 
		String sql = "Select UserIDManager From Account Group By UserIDManager Order By Count(UserIDManager) asc"; //Grab only first row
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		Integer myInt = -1;
		if(rs.next())
		{
			myInt = rs.getInt(1);
		}
		else{
			log.debug("Couldn't retrieve an employeeID");
		}
		conn.setAutoCommit(true);
		end();
		return myInt;
	}

}

