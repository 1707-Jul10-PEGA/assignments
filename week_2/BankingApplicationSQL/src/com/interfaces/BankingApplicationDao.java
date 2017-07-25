package com.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.users.Customer;

public interface BankingApplicationDao {
	public List<Customer.Account> viewBalances(int userID) throws SQLException;
}
