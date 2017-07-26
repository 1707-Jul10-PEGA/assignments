package com.revature.bankingapp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.print.attribute.standard.RequestingUserName;
import javax.sql.rowset.JoinRowSet;

import com.revature.bankingapp.dao.interfaces.BankAccountDaoInterface;
import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.utils.ConnectionFactory;

public class BankAccountDao implements BankAccountDaoInterface{

	Connection conn = null;
	ResultSet resultSet = null;
	ConnectionFactory connFactory = null;
	
	@Override
	public void setup() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		connFactory = ConnectionFactory.getInstance();
	}
			
	public BankAccountDao() {
		try {
			setup();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean logTransaction(UUID accountId, double ammount) {
		String transactionId = UUID.randomUUID().toString();
		Statement statement;

		conn = connFactory.getConnection();
		String sql = "INSERT INTO TRANSACTION_LOG VALUES "
				+ "("
				+ "'" +transactionId+ "',"
				+ "'" +accountId.toString()+ "',"
				+ "sysdate,"
				+ "" +ammount+ ")";
		
		try {
			statement = conn.createStatement();
			statement.executeQuery(sql);
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return false;
	}

	@Override
	public List<BankAccount> getAllAccountsForCustomerWithId(UUID customerId) {
		
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		Statement statement;
		
		conn = connFactory.getConnection();
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE ACCOUNT_ID IN ("
				+ "SELECT ACCOUNT_ID FROM CUSTOMER_OWNS_ACCOUNT WHERE CUSTOMER_ID = '" +customerId.toString()+ "'"
				+ ")"
				+ "";
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				UUID accountId = UUID.fromString(resultSet.getString("ACCOUNT_ID"));
				UUID primaryOwner = UUID.fromString(resultSet.getString("PRIMARY_OWNER_ID"));
				int status = Integer.parseInt(resultSet.getString("STATUS"));
				int accountType = Integer.parseInt(resultSet.getString("ACCOUNT_TYPE"));
				double balance = Double.parseDouble(resultSet.getString("BALANCE"));
				String dateOpened =resultSet.getString("DATE_CREATED");
				BankAccount ac = new BankAccount(accountId, primaryOwner, status, accountType, balance, dateOpened);
								
				accounts.add(ac);
			}
			
			return accounts;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}



	public boolean updateAccountBalance(BankAccount workingAccount) {
		
		Statement statement;
		conn = connFactory.getConnection();
		String accountId = workingAccount.getAccountId().toString();
		double newBalance = workingAccount.getBalance();
		String sql = "UPDATE BANK_ACCOUNT SET BALANCE = " + newBalance + " WHERE ACCOUNT_ID = '" +accountId+ "'" ;
		
		try {
			statement = conn.createStatement();
			statement.executeQuery(sql);
			System.out.println("ACCOUNT UPDATED\n");
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return false;
		}
				
	}
	
	public Map getAvailableTypesOfAccounts(){
		Statement statement;
		conn = connFactory.getConnection();
		String sql = "SELECT * FROM ACCOUNT_TYPE";
		Map map = new HashMap<>();
		
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				int typeId = Integer.parseInt(resultSet.getString("TYPE_ID"));
				String typeDescription = resultSet.getString("TYPE_DESCRIPTION");
				map.put(typeId,typeDescription);
			}
			return map;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return map;
		}
	}
	
	public boolean newBankAccount(BankAccount newAccount, UUID customerId) {
		
		Statement statement = null;
		conn = connFactory.getConnection();
		
		String accountId = newAccount.getAccountId().toString();
		String primaryOwner = newAccount.getPrimaryOwner().toString();
		int status = newAccount.getStatus();
		int accountType = newAccount.getAccountType();
		double balance = newAccount.getBalance();
		String dateCreated = newAccount.getDateOpened();
		
		String sql = "INSERT INTO BANK_ACCOUNT "
				+ "VALUES("
				+ "'" +accountId + "',"
				+ "'" +primaryOwner + "',"
				+ "" +status + ","
				+ "" +accountType + ","
				+ "" +balance + ","
				+ "sysdate)";
		
		try {
			statement = conn.createStatement();
		    statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sql = "INSERT INTO CUSTOMER_OWNS_ACCOUNT "
				+ "VALUES('" +primaryOwner+ "',"
				+ "'" + accountId +  "')";
		
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
	
	
}
