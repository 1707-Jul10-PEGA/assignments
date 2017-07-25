package com.cg.bankingapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankAppDaoImpl implements BankAppDao {
	private Connection connection = null;

	public BankAppDaoImpl() {
		setup();
	}

	private void setup() {
		connection = ConnectionFactory.getInstatnce().getConnection();

	}
	/*
	 * private void close() { try { connection.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 */

	@Override
	public Boolean checkUsername(String username) {
		String sql = "SELECT USERNAME FROM USERINFO WHERE USERNAME=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.executeQuery();

			resultSet = preparedStatement.getResultSet();

			while (resultSet.next()) {
				if (username.equals(resultSet.getString("USERNAME"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			Log.log("There was an error in checking if a username from the database", 3);
		}
		return false;
	}

	@Override
	public Boolean checkPassword(String password) {

		String sql = "SELECT PASSWORD FROM USERINFO WHERE PASSWORD=?";
		String p = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.executeQuery();

			resultSet = preparedStatement.getResultSet();

			while (resultSet.next()) {
				p = resultSet.getString("PASSWORD");
			}
			if (password.equals(p)) {
				return true;
			}
		} catch (SQLException e) {

		}
		return false;
	}

	public User getUser(String username) {
		String firstname, lastname, password;
		int userid, privilege, status;
		String sql = "SELECT * FROM USERINFO WHERE USERNAME=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.executeQuery();

			resultSet = preparedStatement.getResultSet();

			while (resultSet.next()) {
				userid = resultSet.getInt("USERID");
				firstname = resultSet.getString("FIRST_NAME");
				lastname = resultSet.getString("LAST_NAME");
				username = resultSet.getString("USERNAME");
				password = resultSet.getString("PASSWORD");
				privilege = resultSet.getInt("PRIVILEGE");
				status = resultSet.getInt("STATUS");

				if (privilege == 0) {
					Admin admin = new Admin(userid, firstname, lastname, username, password, status);
					preparedStatement.close();
					return admin;
				} else if (privilege == 1) {
					Employee employee = new Employee(userid, firstname, lastname, username, password, status);
					preparedStatement.close();
					return employee;
				} else if (privilege == 2) {
					Customer customer = getCustomer(userid, firstname, lastname, username, password, status);
					preparedStatement.close();
					return customer;
				}
			}
		} catch (SQLException e) {
			Log.log("Sql exception getting user", 3);
		}

		return null;
	}

	// Check customers account(s)
	private Customer getCustomer(int userid, String firstname, String lastname, String username, String password,
			int status) {
		ArrayList<Account> accounts = availableAccounts(userid);
		Customer customer = new Customer(userid, firstname, lastname, username, password, accounts, status);
		return customer;

	}

	private ArrayList<Account> availableAccounts(int userid) {
		String sql = "SELECT * FROM BANKACCOUNTS WHERE USER_ID=?";
		ArrayList<Account> accounts = new ArrayList<Account>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userid);
			preparedStatement.executeQuery();

			resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				int accountid = resultSet.getInt("ACCOUNTID");
				double balance = resultSet.getDouble("BALANCE");
				int accountType = resultSet.getInt("ACCOUNT_TYPEID");
				if (accountType == 1) {
					CheckingsAccount checkingsAccount = new CheckingsAccount(accountid, balance);
					accounts.add(checkingsAccount);
				} else if (accountType == 2) {
					SavingsAccount savingsAccount = new SavingsAccount(accountid, balance);
					accounts.add(savingsAccount);
				}
			}
			preparedStatement.close();
			return accounts;
		} catch (SQLException e) {
			Log.log("Sql exception getting accounts", 3);
		}
		return accounts;

	}

	// Add to the corresponding tables
	public void addUser(User user) {

		if ("admin".equals(user.getAccessRights())) {
			Admin admin = (Admin) user;
			addToUserTable(admin.getFirstname(), admin.getLastname(), admin.getUsername(), admin.getPassword(), 0,
					admin.getStatus());
		} else if ("employee".equals(user.getAccessRights())) {
			Employee employee = (Employee) user;
			addToUserTable(employee.getFirstname(), employee.getLastname(), employee.getUsername(),
					employee.getPassword(), 1, employee.getStatus());
		} else {
			Customer customer = (Customer) user;
			addToUserTable(customer.getFirstname(), customer.getLastname(), customer.getUsername(),
					customer.getPassword(), 2, customer.getApproved());
			addToBankTable(customer);
		}

	}

	// Adds a user to the table
	private void addToUserTable(String firstname, String lastname, String username, String password, int privilege,
			int status) {
		String sql = "INSERT INTO USERINFO VALUES(USER_SEQUENCE.NEXTVAL,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5, privilege);
			preparedStatement.setInt(6, status);
			preparedStatement.executeQuery();
			preparedStatement.close();
		} catch (SQLException e) {
			Log.log("Sql exception getting user", 3);
		}
	}

	public void addToBankTable(Customer customer) {

	}

	public void logToTable(String activity, User user, int accountid, double amount) {
		String sql = "INSERT INTO LOGS VALUES(LOG_SEQUENCE.NEXTVAL,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setTimestamp(1, java.sql.Timestamp.from(java.time.Instant.now()));
			preparedStatement.setString(2, activity);
			preparedStatement.setInt(3, user.getUserid());
			if ("customer".equals(user.getAccessRights())) {
				preparedStatement.setInt(4, accountid);
				preparedStatement.setDouble(5, amount);
			} else {
				preparedStatement.setNull(4, java.sql.Types.INTEGER);
				preparedStatement.setNull(5, java.sql.Types.INTEGER);
			}
			preparedStatement.executeQuery();
			preparedStatement.close();

		} catch (SQLException e) {
			Log.log("Sql exception - error logging to table. ", 3);
			e.printStackTrace();
		}
	}

	public void updateBalance(int accountid, double balance) {
		String sql = "UPDATE BANKACCOUNTS SET BALANCE=? WHERE ACCOUNTID=? ";
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, balance);
			preparedStatement.setInt(2, accountid);
			preparedStatement.executeQuery();
			preparedStatement.close();

		} catch (SQLException e) {
			Log.log("Sql exception - error withdrawing money from user account. ", 3);
			e.printStackTrace();
		}
	}

	public Object updateUsername(String username) {

		return null;
	}

	public ArrayList<User> getUsers() {
		String sql = "SELECT USERNAME FROM USERINFO";
		ArrayList<User> users = new ArrayList<User>();
		String username;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				username = resultSet.getString("USERNAME");
				User user = getUser(username);
				Log.log("Adding user to users list " + username, 2);
				users.add(user);
			}
		} catch (SQLException e) {
			Log.log("Sql exception - error retriving users from the database. ", 3);
			e.printStackTrace();
		}
		return users;
	}

	public void deactivateUser(User user) {
		String sql = "UPDATE USERINFO SET STATUS=? WHERE USERID=? ";
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, -1);
			preparedStatement.setInt(2, user.getUserid());
			preparedStatement.executeQuery();
			preparedStatement.close();

		} catch (SQLException e) {
			Log.log("Sql exception - error deactivating user with "+ user.getUserid(), 3);
			e.printStackTrace();
		}
	}

}
