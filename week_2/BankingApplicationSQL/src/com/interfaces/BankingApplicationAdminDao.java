package com.interfaces;

import java.sql.SQLException;

public interface BankingApplicationAdminDao extends BankingApplicationEmployeeDao{
	public void runSQL();
	public void depositAny()throws SQLException;
	public void withdrawAny()throws SQLException;
	public void approveDenyAny()throws SQLException;
	public void viewAnyBalance()throws SQLException;
	
	public void createEmployee()throws SQLException;
}
