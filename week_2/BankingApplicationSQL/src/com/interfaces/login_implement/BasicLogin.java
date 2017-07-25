package com.interfaces.login_implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.connection.ConnectionFactory;
import com.interfaces.Login;
import com.users.Admin;
import com.users.Customer;
import com.users.Employee;
import com.users.User;

public class BasicLogin implements Login {

	private Logger log = Logger.getRootLogger();

	Connection conn = null;

	public void setup() {
		conn = ConnectionFactory.getInstance().getConnection();
	}

	public BasicLogin() {
		super();
		// TODO Auto-generated constructor stub
		setup();
	}

	@Override
	public User login(String userName, String password) {
		String sqlStatement = "SELECT * FROM ALLUSERS WHERE USERNAME = ? AND PASS_WORD = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sqlStatement);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				User ret = null;
				if(rs.getInt(6) == 0){
					
					ret = new Customer();
					sqlStatement = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
					pstmt = conn.prepareStatement(sqlStatement);
					pstmt.setInt(1, rs.getInt(1));
					ResultSet temp_rs = pstmt.executeQuery();
					temp_rs.next();
					((Customer)ret).setBANKER_ID(temp_rs.getInt(2));
				}else if(rs.getInt(6) == 1){
					ret = new Employee();
					
				}
				
				else if(rs.getInt(6) == 2){
					ret = new Admin();
				}else{
					System.out.println("Invalid user type");
					log.error("INVALID USER TYPE IN DATABASE, USER_TYPE_ID: " + rs.getInt(6));
					return null;
				}

				ret.setUser_id(rs.getInt(1));
				ret.setPassword(rs.getString(2));
				ret.setFirstName(rs.getString(3));
				ret.setLastName(rs.getString(4));
				ret.setAge(rs.getInt(5));
				ret.setUserName(rs.getString(7));
				
				return ret;
			}else{
				System.out.println("  ** Incorrect username or password.");
				log.warn("Incorrect login, username: " + userName + " , password: " + password);
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		return null;
	}

}
