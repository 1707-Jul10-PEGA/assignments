package com.WilliamLewis.BankingApp.JDBC.DoAs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.JDBC.Connection.ConnectionFactory;
import com.WilliamLewis.BankingApp.Users.Admin;
import com.WilliamLewis.BankingApp.Users.Customer;
import com.WilliamLewis.BankingApp.Users.Employee;
import com.WilliamLewis.BankingApp.Users.User;

public class UserImplementDOA {
	private static UserImplementDOA UserDOA = null;
	private static Boolean build = true;
	Connection conn = null;
	private static Logger log = Logger.getRootLogger();
	private UserImplementDOA(){
		
	}
	
	public static synchronized UserImplementDOA getInstance(){
		if(build){
			UserDOA = new UserImplementDOA();
		}
		return UserDOA;
	}
	public void setup(){
		//log.debug("Attempting to use Connection Factory");
		conn = ConnectionFactory.getInstance().getConnection();
		
	}
	public void end(){
		try {
			conn.close();
		} catch (SQLException e) {
			log.debug( "AHHH COULDN'T CLOSE IT SCOTTY");
			e.printStackTrace();
		}
	}
	
	
	public int createUser(User myUser, int type) throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		String sql = "insert into Users(UserID, UserName, Password, UserTypeID, FirstName, LastName"
				+ ") values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);
		pstmt.setString(2, myUser.getUsername());
		pstmt.setString(3, myUser.getPassword());
		pstmt.setInt(4, type);
		pstmt.setString(5, myUser.getFirstName());
		pstmt.setString(5, myUser.getLastName());
		
		
		Savepoint s = conn.setSavepoint();
		
		int num = pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		
		
		if (num > 1){
			
			conn.rollback(s);
		}
		conn.commit();
		
		conn.setAutoCommit(true);
		end();
		return rs.getInt(1);
		
		
	}	
	public int getUserIdOnLogin(String userName, String pass) throws SQLException{
		setup();
		conn.setAutoCommit(false);
		
		String sql = "SELECT UserID FROM USERS WHERE"
				+ " Users.UserName = ? AND Users.Password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		pstmt.setString(2, pass);
		
		Savepoint s = conn.setSavepoint();
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int myUserID = rs.getInt(1);
		
		conn.setAutoCommit(true);
		
		end();
		return myUserID;
	}
	public int getUserTypeOnID(Integer userID) throws SQLException{
	setup();
	conn.setAutoCommit(false);
	
	String sql = "SELECT UserTypeID FROM USERS WHERE"
			+ " Users.UserID = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, userID);
	
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int myResult = rs.getInt(1);
	
	conn.setAutoCommit(true);
	
	end();
	return myResult;
	}
	public ArrayList<User> getAllUsers() throws SQLException{
		setup();
		
		conn.setAutoCommit(false);
		
		ArrayList<User> myUsers = new ArrayList<User>();
		
		String sql = "SELECT * FROM Users";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.executeQuery();
		
		
		ResultSet rs = pstmt.executeQuery();
		User user;
		int accType;
		while(rs.next())
		{
			log.debug("Reading a result set row ...");
			accType = rs.getInt("USERTYPEID");
			log.debug("Switching according to type");
			switch(accType){
			
			
			case 0 : user = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6));
					myUsers.add(user);
					break;
			case 1 :user = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6));
					myUsers.add(user);
					break;
			case 2: user = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6));
					myUsers.add(user);
					break;
			default: log.error("User type in Database has an unexpected value (should be 0, 1, xor 2");
			
			}
			log.debug("Read a result set row");
		}
			
		
		
		conn.setAutoCommit(true);
		end();
		return myUsers;
	}
	
	
}
