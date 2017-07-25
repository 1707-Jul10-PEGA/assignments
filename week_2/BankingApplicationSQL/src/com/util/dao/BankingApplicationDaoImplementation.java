package com.util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionFactory;
import com.interfaces.BankingApplicationDao;
import com.users.Customer;

public class BankingApplicationDaoImplementation implements BankingApplicationDao {
	Connection conn = null;
	
	public void setup(){
		conn = ConnectionFactory.getInstance().getConnection();
	}
	
	public BankingApplicationDaoImplementation(){
		super();
		// TODO Auto-generated constructor stub
		setup();
	}


	public List<Customer.Account> viewBalances(int userID) throws SQLException{
		String sqlStatement = "SELECT * FROM ACCOUNTS WHERE CUSTOMER_ID = ? AND ACCOUNT_STATUS = 'ACTIVE'";
		
		PreparedStatement pstmt =  conn.prepareStatement(sqlStatement);
		pstmt.setInt(1,userID);
		ResultSet rs = pstmt.executeQuery();
		List<Customer.Account> retAccounts = new ArrayList<Customer.Account>();
		Customer c = new Customer();
		while(rs.next()){
			retAccounts.add(c.new Account(rs.getString(4), rs.getDouble(2)));
			
		}
		pstmt.close();
		rs.close();
		return retAccounts;
	}
	
	@Override
	public void finalize(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");

		BankingApplicationDao BD = new BankingApplicationDaoImplementation();
		List<Customer.Account> customerAccounts = null;
		 try {
			customerAccounts = BD.viewBalances(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 for(Customer.Account ac : customerAccounts){
			 System.out.println(ac.getAccountName() + ": "+ac.getBalance());			 
		 }
	}
}
