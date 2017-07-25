package com.EC.hw2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.EC.hw1.Utilities.DAOUtilities;

public class BankAccountDAOImpl implements BankAccountDAO {

	private Connection connection = null;
	private PreparedStatement stmt = null;

	/* Creating a bank account for when customer logs in. Will close all the
	 BankAccount read resources from the CustomerDAOImpl
	 */
	
	@Override
	public double getCheckingAccountValue(String username) {
		double checking = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT BA.BALANCE "
						+ "FROM USER_TABLE UT "
						+ "INNER JOIN BANK_ACCOUNT BA ON UT.U_ID = BA.U_ID "
						+ "WHERE USERNAME = ? AND BA.BANK_ACCOUNT_TYPE=1";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				checking = rs.getDouble("BALANCE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checking;
	}

	@Override
	public double getSavingAccountValue(String username) {
		double checking = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT BA.BALANCE "
					+ "FROM USER_TABLE UT "
					+ "INNER JOIN BANK_ACCOUNT BA ON UT.U_ID = BA.U_ID "
					+ "WHERE USERNAME = ? AND BA.BANK_ACCOUNT_TYPE=2";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				checking = rs.getDouble("BALANCE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checking;
	}

	@Override
	public double getCreditAccountValue(String username) {
		double checking = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT BA.BALANCE "
					+ "FROM USER_TABLE UT "
					+ "INNER JOIN BANK_ACCOUNT BA ON UT.U_ID = BA.U_ID "
					+ "WHERE USERNAME = ? AND BA.BANK_ACCOUNT_TYPE=3";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				checking = rs.getDouble("BALANCE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//We close the resource within the CustomerDAOImpl class
		return checking;
	}

	/*
	 * once a customer is approved, all his accounts are active. Customers
	 * cannot just have one account active and two deactivated. Therefore we can
	 * select any account and know whether all his account are active or if they
	 * are all deactivated.
	 */
	public boolean isActive(String username) {
		int status = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT BA.STATUS "
					+ "FROM USER_TABLE UT "
					+ "INNER JOIN BANK_ACCOUNT BA ON UT.U_ID = BA.U_ID "
					+ "WHERE USERNAME = ? AND BA.BANK_ACCOUNT_TYPE=3";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				status = rs.getInt("STATUS");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return (status == 0) ? false : true;
	}

	public String getEmail(String username) {
		String email = null;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT BA.EMAIL "
					+ "FROM USER_TABLE UT "
					+ "INNER JOIN BANK_ACCOUNT BA ON UT.U_ID = BA.U_ID "
					+ "WHERE USERNAME = ? AND BA.BANK_ACCOUNT_TYPE=3";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				email =rs.getString("EMAIL");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return email;
	}
	
	@Override
	public Date getLastLogin(String username) {
		Date lastLogin = null;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT BA.LASTLOGIN "
					+ "FROM USER_TABLE UT "
					+ "INNER JOIN BANK_ACCOUNT BA ON UT.U_ID = BA.U_ID "
					+ "WHERE USERNAME = ? AND BA.BANK_ACCOUNT_TYPE=3";

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


	/* updates the customers' bank accounts. Currently, check operations are
	 happening on client side. Part of objects behavior
	 */

	@Override
	public boolean updateChecking(int u_id, double amount) {
		int updates = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE BANK_ACCOUNT BA " + "SET BALANCE = ? "
					+ "WHERE BA.U_ID = ? AND BA.BANK_ACCOUNT_TYPE = 1";
			stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, amount);
			stmt.setInt(2, u_id);
			updates = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		return (updates == 0) ? false : true;
	}

	@Override
	public boolean updateSaving(int u_id, double amount) {
		int updates = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE BANK_ACCOUNT BA " + "SET BALANCE = ? "
					+ "WHERE BA.U_ID = ? AND BA.BANK_ACCOUNT_TYPE = 2";
			stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, amount);
			stmt.setInt(2, u_id);
			updates = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		return (updates == 0) ? false : true;
	}

	@Override
	public boolean updateCredit(int u_id, double amount) {
		int updates = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE BANK_ACCOUNT BA " + "SET BALANCE = ? "
					+ "WHERE BA.U_ID = ? AND BA.BANK_ACCOUNT_TYPE = 3";
			stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, amount);
			stmt.setInt(2, u_id);
			updates = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		return (updates == 0) ? false : true;
	}
	
	@Override
	public boolean updateStatus(int u_id, int active) {//1:account is active, 0:account is not active
		int updates = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE BANK_ACCOUNT BA " + "SET STATUS = ? "
					+ "WHERE BA.U_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, active);
			stmt.setInt(2, u_id);
			updates = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		return (updates == 0) ? false : true;
	}
	
	public boolean updateLastLogin(int u_id){
		int updates = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE BANK_ACCOUNT BA " + "SET LASTLOGIN = CURRENT_TIMESTAMP "
					+ "WHERE BA.U_ID = ?";
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
