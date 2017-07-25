package com.WilliamLewis.BankingApp.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.AccountFactory.AccountFactory;
import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
/**
 * Similar implementation to the admin, but with some personal tracking of Applications and accounts to manage
 * @author William
 *
 */
public class Employee extends User implements Serializable{
	private static Logger log = Logger.getRootLogger();
//	public ArrayList<AccountApplication> pendingApplications;
//	private ArrayList<Integer> accountIdsToManage;
	private static final long serialVersionUID = 54321L;
	
	public Employee()
	{
		super();
	}

	
	public Employee(Integer userID, String username, String password, String firstName, String lastName)
	{
		super(userID, username, password, firstName, lastName);
	}

	
	
}
