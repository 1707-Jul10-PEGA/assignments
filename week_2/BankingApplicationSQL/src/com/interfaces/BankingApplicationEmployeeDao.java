package com.interfaces;

import java.sql.SQLException;

public interface BankingApplicationEmployeeDao extends BankingApplicationDao {
	public void approveDeny(int bankerID) throws SQLException;

	void viewCustomerBalances(int bankerID)  throws SQLException;
}
