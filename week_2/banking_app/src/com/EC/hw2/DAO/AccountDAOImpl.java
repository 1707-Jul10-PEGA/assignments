package com.EC.hw2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.EC.hw1.Utilities.DAOUtilities;

public class AccountDAOImpl implements AccountDAO{
	private Connection connection;
	private PreparedStatement stmt;
	
	@Override
	public Date getLastLogin(String username) {
		Date lastLogin = null;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT A.LASTLOGIN "
					+ "FROM USER_TABLE UT "
					+ "INNER JOIN EMPLOYEE_ACCOUNT A ON UT.U_ID = A.EA_ID "
					+ "WHERE USERNAME = ?";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				lastLogin =rs.getDate("LASTLOGIN");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return lastLogin;
	}
	
	public boolean updateLastLogin(int u_id){
		int updates = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE EMPLOYEE_ACCOUNT A " 
					+ "SET LASTLOGIN = CURRENT_TIMESTAMP "
					+ "WHERE A.EA_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, u_id);
			updates = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		return (updates == 0) ? false : true;
	}

	/* Closing all resources is important, to prevent memory leaks.
	 Ideally, you really want to close them in the reverse-order you open them*/
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}

		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}
	
}
