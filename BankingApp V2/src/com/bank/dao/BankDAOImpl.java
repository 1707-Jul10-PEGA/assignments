package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.bank.user.User;
import com.bank.util.ConnectionFactory;

public class BankDAOImpl implements BankUserDAO {
	Connection conn = null;
	List<User> allUsers;
	public void setup(){
		
		conn = ConnectionFactory.getInstance().getConnection();
		
	}
	
	public BankDAOImpl() {
		// TODO Auto-generated constructor stub
		
		setup();
		
	}

	@Override
	public User getUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from wphipps.bankusers " +
					"where user_id = " + 
					id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		User tempUser = new User();
		//user_id, first, last, uname, pass, p_id
		while(rs.next()){
			
			
			tempUser.setfName(rs.getString(2));
			
			tempUser.setlName(rs.getString(3));
			
			tempUser.setuName(rs.getString(4));
			
			tempUser.setPass(rs.getString(5));
			
			switch (rs.getString(6)){
			case "1":
				tempUser.setPosition("customer");
				break;
			case "2":
				tempUser.setPosition("employee");
				break;
			case "3":
				tempUser.setPosition("admin");
				break;
			}
			
		}
		return tempUser;
	}

	@Override
	public int saveUser(User u) throws SQLException {
		//user_id, first, last, username, u_pass, p_id
		String sql = 	"insert into wphipps.bankusers (user_id, first_name, last_name, username, u_pass, p_id) values(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);
		pstmt.setString(2, u.getfName());
		pstmt.setString(3, u.getlName());
		pstmt.setString(4, u.getuName());
		pstmt.setString(5, u.getPass());
		
		//customer - 1, employee - 2, admin - 3
		switch(u.getPosition()){
		case "customer":
			pstmt.setInt(6, 1);
			break;
		case "employee":
			pstmt.setInt(6, 2);
			break;
		case "admin":
			pstmt.setInt(6, 3);
			break;
		}
		return pstmt.executeUpdate();
		
	}
	
	@Override
	public void updateUser(User u, String oldUser) throws SQLException {
		// TODO Auto-generated method stub
		String sql = 	"update wphipps.bankusers set first_name = ?, last_name = ?, username = ?, u_pass = ?, where username = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, u.getfName());
		pstmt.setString(2, u.getlName());
		pstmt.setString(3, u.getuName());
		pstmt.setString(4, u.getPass());
		pstmt.setString(5, oldUser);
		
		pstmt.executeUpdate();
		
		Statement stmt = conn.createStatement();
		
		
		sql = "select * from wphipps.bankusers where username = " + u.getuName();
				
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			
			System.out.println(rs.getString(2));
			
		}
		

	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from wphipps.bankusers";
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		List<User> allUsers = new ArrayList<User>();
		

		//user_id, first, last, username, u_pass, p_id
		while(rs.next()){
			User me = new User();
			me.setdbID(rs.getInt(1));
			me.setfName(rs.getString(2));
			me.setlName(rs.getString(3));
			me.setuName(rs.getString(4));
			me.setPass(rs.getString(5));
			switch (rs.getInt(6)){
			case 1:
				me.setPosition("customer");
			break;
			case 2:
				me.setPosition("employee");
				break;
			case 3:
				me.setPosition("admin");
				break;
			}
		allUsers.add(me);
		}
		return allUsers;
	}

	@Override
	public int deleteUser(int... ids) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void logTransaction(int userID, int acctID, double amount, String action) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into wphipps.transactionlog (time_of_transaction, user_id, acct_id, activity, amount) values (?, ?, ?, ?, ?)";
		System.out.println("log");
		Calendar calendar = Calendar.getInstance();
		Timestamp myTsObject = new Timestamp(calendar.getTime().getTime());
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setTimestamp(1, myTsObject);
		pstmt.setInt(2, userID);
		pstmt.setInt(3, acctID);
		pstmt.setString(4, action);
		pstmt.setDouble(5, amount);
		pstmt.executeUpdate();
	}

	@Override
	public int newBankAccount(int idIN) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into wphipps.accounts (account_id, balance, cust_id, status) values (?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);
		pstmt.setDouble(2, 0.00);
		pstmt.setInt(3, idIN);
		pstmt.setString(4, "inactive");
		sql = "select account_id from wphipps.accounts order by account_id asc";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		int[] intAr = new int[100];
		int x = 0;
		while(rs.next()){
			intAr[x] = rs.getInt(1);
			
			x++;
		}
		this.logTransaction(idIN, intAr[1], 0.0, "applied");
		return intAr[0];
	}
	
	@Override
	public void approveAccount(int empID, int acctID) throws SQLException {
		
		String sql = "update wphipps.accounts set status = 'active', activator_id = ? where account_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, empID);
		ps.setInt(2, acctID);
		ps.executeQuery();
	}
	
	@Override
	public void denyAccount(int acctID) throws SQLException{
		String sql = "delete from wphipps.accounts where account_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, acctID);
		ps.executeQuery();
	}
	
	@Override
	public void viewMyAccounts(int idIN) throws SQLException {
		// idIN is the customer id
		String sql = "select account_id, balance, cust_id, status from wphipps.accounts where cust_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idIN);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			System.out.println("Account ID: " + rs.getInt(1));
			System.out.println("Balance: " + rs.getString(2));
			System.out.println("Owner ID: " + rs.getString(3));
			System.out.println("Status: " + rs.getString(4));
			System.out.println();
		}
	
	}
	
	@Override
	public void viewEmployeeAccounts(int empID) throws SQLException {
		String sql = "select account_id, balance, cust_id, status from wphipps.accounts where activator_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empID);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			System.out.println("Account ID: " + rs.getInt(1));
			System.out.println("Balance: " + rs.getString(2));
			System.out.println("Owner ID: " + rs.getString(3));
			System.out.println("Status: " + rs.getString(4));
			System.out.println();
		}
		
	}
	
	@Override
	public void viewInactiveAccounts() throws SQLException {
		String sql = "select account_id, balance, cust_id, status from wphipps.accounts where status = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "inactive");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			System.out.println("Account ID: " + rs.getInt(1));
			System.out.println("Balance: " + rs.getString(2));
			System.out.println("Owner ID: " + rs.getString(3));
			System.out.println("Status: " + rs.getString(4));
			System.out.println();
		}
		
	}
	
	@Override
	public void viewAllAccounts() throws SQLException{
		List<User> all = this.getAllUsers();
		for(int x = 0; x < all.size(); x++){
			this.viewMyAccounts(all.get(x).getDb_id());
		}
	}

	@Override
	public void deposit(User u, int accID, double amount) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select balance, status from wphipps.accounts where account_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, accID);
		ResultSet rs = pstmt.executeQuery();
		String status;
		rs.next();
		status = rs.getString(2);
		
		if(status.equals("active")){
			double originalBalance = rs.getDouble(1);
			sql = "update wphipps.accounts set balance = ? where account_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, (originalBalance + amount));
			pstmt.setInt(2, accID);
			pstmt.executeQuery();
			this.logTransaction(u.getDb_id(), accID, amount, "deposit");
		}
		else{
			System.err.println("YOU CAN'T DO THAT");
			this.logTransaction(u.getDb_id(), accID, amount, "Inactive Deposit Violation");
		}
		
	}
	
	@Override
	public void withdraw(User u, int accID, double amount) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select balance, status from wphipps.accounts where account_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, accID);
		ResultSet rs = pstmt.executeQuery();
		String status;
		rs.next();
		double balance = rs.getDouble(1);
		if(balance >= amount){

			status = rs.getString(2);
			if(status.equals("active")){
				double originalBalance = rs.getDouble(1);
				sql = "update wphipps.accounts set balance = ? where account_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setDouble(1, (originalBalance - amount));
				pstmt.setInt(2, accID);
				pstmt.executeQuery();
				this.logTransaction(u.getDb_id(), accID, amount, "deposit");
			}
			else{
				System.err.println("YOU CAN'T DO THAT");
				this.logTransaction(u.getDb_id(), accID, amount, "Inactive Withdraw Violation");
			}
		}
		else{
			System.err.println("OVERDRAFT VIOLATION");
			this.logTransaction(u.getDb_id(), accID, amount, "Overdraft");
		}
	}
	
	@Override
	public void singleAccount(int acctID) throws SQLException{
		// idIN is the customer id
			String sql = "select account_id, balance, cust_id, status from wphipps.accounts where account_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acctID);
			ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				System.out.println("Account ID: " + rs.getInt(1));
				System.out.println("Balance: " + rs.getString(2));
				System.out.println("Owner ID: " + rs.getString(3));
				System.out.println("Status: " + rs.getString(4));
				}
	}
	
}
