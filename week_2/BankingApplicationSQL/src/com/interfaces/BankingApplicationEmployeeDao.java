package com.interfaces;

import java.sql.SQLException;

public interface BankingApplicationEmployeeDao extends BankingApplicationDao {
	public void approveDeny(int bankerID) throws SQLException;

	void viewCustomerBalances(int bankerID)  throws SQLException;

	public void createUser(int user_id) throws SQLException;
}
