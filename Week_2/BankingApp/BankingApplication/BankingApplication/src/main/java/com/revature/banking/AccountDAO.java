package com.revature.banking;

import java.sql.SQLException;

public interface AccountDAO {
	BankAccount getAccount(int id) throws SQLException;
	
	int saveAccount() throws SQLException;
	
	void updateAccount(BankAccount a,String type) throws SQLException;
	
	java.util.List<BankAccount> getAllAccount() throws SQLException;

}
