package com.interfaces;

import java.sql.SQLException;

public interface BankingApplicationCustomerDao extends BankingApplicationDao {
	
	//deposit
	public void deposit(int customerID) throws SQLException;
	
	//withdraw
	public void withdraw(int customerID) throws SQLException;
	
	//apply for account
	public void apply(int customerID) throws SQLException;
	
	public static void main(String[] args) {
		
	}
}
