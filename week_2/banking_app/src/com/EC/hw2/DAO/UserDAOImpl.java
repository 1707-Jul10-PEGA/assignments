package com.EC.hw2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EC.hw1.Model.User;
import com.EC.hw1.Utilities.DAOUtilities;

public class UserDAOImpl implements UserDAO {
	private Connection connection;
	private PreparedStatement stmt;
	
	
	@Override
	public boolean usernameExist(String username) {
		int doesExist = 0;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM USER_TABLE WHERE USERNAME = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				doesExist++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		return (doesExist == 0) ? false : true;
	}
	
	@Override
	public boolean applyForAccount(User u) {
		int insert = 0;
		try{
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO USER_TABLE VALUES(0,?,?,?,?,1)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getUserName());
			stmt.setString(4,u.getPassword());
			insert = stmt.executeUpdate();
			//ask Nick
			ResultSet rs = stmt.getGeneratedKeys(); //updated u_id for new user
			int u_id = rs.getInt(1);
			u.setUser_id(u_id);
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			closeResources();
		}
		
		return (insert==0)?false:true ; //most likely that username has been taken if false
	}
	
	@Override
	public boolean assignBanker(int c_id) {
		List<Integer> eidList = new ArrayList<Integer>();
		int insert = 0 ;
		try{
			connection = DAOUtilities.getConnection();
			String sql = "SELECT U_ID FROM USER_TABLE WHERE PRIVELEDGE = 2"; //grab all available employees
			stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				eidList.add(rs.getInt("U_ID"));
			}
			int e_id = randomBanker(eidList);
			sql = "INSERT INTO CUSTOMERS VALUES(?,?)";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, e_id);
			stmt.setInt(2, c_id);
			
			insert = stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			closeResources();
		}
		return (insert==0)?false:true;
	}
	
	//eidlist will never be zero. employees will always be in the database
	private int randomBanker(List<Integer> eidList) {
		int randomNumber = (int)(Math.random() * (eidList.size()-1)+0);
		return eidList.get(randomNumber); //return the employee_id
	}

	@Override
	public User getUser(String username) {
		User user = null;
		try{
			connection = DAOUtilities.getConnection();
			String sql = "SELECT U_ID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD, PRIVELEDGE " +
							"FROM USER_TABLE "
							+"WHERE USERNAME = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				user = new User();
				user.setUser_id(rs.getInt("U_ID"));
				user.setFirstName(rs.getString("FIRSTNAME"));
				user.setLastName(rs.getString("LASTNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUserName(rs.getString("USERNAME"));
				user.setPriveledge(rs.getInt("PRIVELEDGE"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeResources();
		}
		return user;
	}
	
	
	// Closing all resources is important, to prevent memory leaks. 
	// Ideally, you really want to close them in the reverse-order you open them
	private void closeResources() {
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException e) {
					System.out.println("Could not close statement!");
					e.printStackTrace();
				}
				
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					System.out.println("Could not close connection!");
					e.printStackTrace();
				}
			}

	

	
	
}
