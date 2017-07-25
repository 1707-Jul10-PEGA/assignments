package com.EC.hw2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.EC.hw1.Model.BankAccount;
import com.EC.hw1.Model.Customer;
import com.EC.hw1.Utilities.DAOUtilities;

public class CustomerDAOImpl implements CustomerDAO {

	private Connection connection = null; //Our connection to the database
	private PreparedStatement stmt = null; //We user prepared statement to prevent SQL injection
	
	@Override
	public Customer getCustomer(String username) {
		Customer c = null;
		BankAccountDAO dao = DAOUtilities.getBankAccountDAO();
		try{
			connection = DAOUtilities.getConnection();
			String sql = "SELECT U_ID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD, PRIVELEDGE " +
							"FROM USER_TABLE "
							+"WHERE USERNAME = ? AND PRIVELEDGE = 1";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				c = new Customer();
				BankAccount ba = new BankAccount();
				c.setUser_id(rs.getInt("U_ID"));
				c.setFirstName(rs.getString("FIRSTNAME"));
				c.setLastName(rs.getString("LASTNAME"));
				c.setPassword(rs.getString("PASSWORD"));
				c.setUserName(rs.getString("USERNAME"));
				c.setPriveledge(rs.getInt("PRIVELEDGE"));
				ba.setCashAccount(dao.getCheckingAccountValue(username));
				ba.setSavingAccount(dao.getSavingAccountValue(username));
				ba.setCreditAccount(dao.getCreditAccountValue(username));
				ba.setActive(dao.isActive(username));
				ba.setEmail(dao.getEmail(username));
				ba.setLastLogin(dao.getLastLogin(username));
				c.setBankAccount(ba);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(c!=null){
				dao.updateLastLogin(c.getUser_id());
			}
			closeResources();
		}
		return c;
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
