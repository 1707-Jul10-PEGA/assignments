package com.MS.OJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.MS.BankApp.Application;


public class UserDAO {
	
	Connection conn = null;
	
	public void setup() throws SQLException{
		
		conn = ConnectionFactory.getInstance().getConnection();
	}

	public UserDAO()
	{
		try {
			setup();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateUser(String userID, String name, String priv, String acctno, String checking, String savings, String assignedto, String requests) throws SQLException
	{
		conn.setAutoCommit(false);
		String sql = "UPDATE USERS SET NAME=?, PRIV=?, ACCTNO=?,CHECKING=?,SAVINGS=?,ASSIGNEDTO=?,REQUESTS=?"
				+" WHERE ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, priv);
		pstmt.setString(3, acctno);
		pstmt.setString(4, checking);
		pstmt.setString(5, savings);
		pstmt.setString(6, assignedto);
		pstmt.setString(7, requests);
		pstmt.setString(8, userID);
		pstmt.executeUpdate();
		
		Savepoint s = conn.setSavepoint();
		
		conn.commit();
		
		conn.setAutoCommit(true);
		
	}
	
	public int saveUser(String ID, String name, String priv, String acctno, String checking, String savings, String assignedto, String requests) throws SQLException{
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String sql = "INSERT INTO USERS (ID, NAME, PRIV, ACCTNO, CHECKING, SAVINGS, ASSIGNEDTO, REQUESTS)"
				+" VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ID);
		pstmt.setString(2, name);
		pstmt.setString(3, priv);
		pstmt.setString(4, acctno);
		pstmt.setString(5, checking);
		pstmt.setString(6, savings);
		pstmt.setString(7, assignedto);
		pstmt.setString(8, requests);
		pstmt.executeUpdate();
		
		Savepoint s = conn.setSavepoint();
		
		conn.commit();
		
		conn.setAutoCommit(true);
		
		return 1;
	}

	public void saveLog(String action, String aff, String account, String amount) throws SQLException
	{
		conn.setAutoCommit(false);
		String sql = "INSERT INTO LOGGER (ACTION, USR, AFFUSR, ACCT, AMOUNT) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, action);
		pstmt.setString(2, Application.namelist[Application.userid]);
		pstmt.setString(3, aff);
		pstmt.setString(4, account);
		pstmt.setString(5, amount);
		pstmt.executeUpdate();
		
		conn.commit();
		
		conn.setAutoCommit(true);
	}
	
	public void viewLog() throws SQLException
	{
		Statement stmt;
		ResultSet rs = null;
		
		String sql;
		sql = "SELECT * FROM LOGGER";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.print(" TIMESTAMP: " + rs.getDate("TIMEST"));
				System.out.print(" ACTION: " + rs.getString("ACTION"));
				System.out.print(" USER: "+ rs.getString("USR"));
				System.out.print(" AFFECTED USER: " + rs.getString("AFFUSR"));
				System.out.print(" ACCOUNT: " + rs.getString("ACCT"));
				System.out.print(" AMOUNT: " + rs.getString("AMOUNT") + "\n\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
