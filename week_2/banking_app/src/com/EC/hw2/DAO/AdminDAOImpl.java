package com.EC.hw2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.EC.hw1.Model.Account;
import com.EC.hw1.Model.Admin;
import com.EC.hw1.Utilities.DAOUtilities;

public class AdminDAOImpl implements AdminDAO {
	private Connection connection;
	private PreparedStatement stmt;
	
	@Override
	public Admin getAdmin(String username) {
		Admin admin = null;
		AccountDAO dao = DAOUtilities.getAccountDAO();
		try{
			connection = DAOUtilities.getConnection();
			String sql = "SELECT U_ID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD, PRIVELEDGE " +
							"FROM USER_TABLE "
							+"WHERE USERNAME = ? AND PRIVELEDGE = 3";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				admin = new Admin();
				Account a = new Account();
				admin.setUser_id(rs.getInt("U_ID"));
				admin.setFirstName(rs.getString("FIRSTNAME"));
				admin.setLastName(rs.getString("LASTNAME"));
				admin.setPassword(rs.getString("PASSWORD"));
				admin.setUserName(rs.getString("USERNAME"));
				admin.setPriveledge(rs.getInt("PRIVELEDGE"));
				a.setLastLogin(dao.getLastLogin(username));
				admin.setAccount(a);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(admin != null){
				dao.updateLastLogin(admin.getUser_id());
			}
			closeResources();
		}
		return admin;
	}

	/* Closing all resources is important, to prevent memory leaks.
	 Ideally, you really want to close them in the reverse-order you open them*/
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
