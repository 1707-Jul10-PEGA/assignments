package com.EC.hw2.DAO;

import java.util.Date;

public interface BankAccountDAO {
	
	public double getCheckingAccountValue(String username);
	public double getSavingAccountValue(String username);
	public double getCreditAccountValue(String username);
	public Date getLastLogin(String username);
	public boolean isActive(String username);
	public String getEmail(String username);
	public boolean updateChecking(int u_id, double amount);
	public boolean updateSaving(int u_id, double amount);
	public boolean updateCredit(int u_id, double amount);
	public boolean updateStatus(int u_id, int active);
	public boolean updateLastLogin(int u_id);
	
}
