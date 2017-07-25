package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.user.User;

public interface BankUserDAO {
		
		
		User getUser(int id) throws SQLException;
		int saveUser(User u) throws SQLException;		
		void updateUser (User u, String oldUser) throws SQLException;		
		List<User> getAllUsers() throws SQLException;		
		int deleteUser(int ... ids) throws SQLException;
		void viewMyAccounts(int idIN) throws SQLException;
		void logTransaction(int userID, int acctID, double amount, String action) throws SQLException;
		int newBankAccount(int inID) throws SQLException;
		void deposit(User u, int accID, double amount) throws SQLException;
		void withdraw(User u, int accID, double amount) throws SQLException;
		void viewAllAccounts() throws SQLException;
		void viewEmployeeAccounts(int empID) throws SQLException;
		public void viewInactiveAccounts() throws SQLException;
		public void approveAccount(int empID, int acctID) throws SQLException;
		public void denyAccount(int acctID) throws SQLException;
		public void singleAccount(int acctID) throws SQLException;
		
}
