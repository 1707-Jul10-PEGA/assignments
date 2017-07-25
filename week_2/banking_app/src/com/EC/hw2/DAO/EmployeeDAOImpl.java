package com.EC.hw2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.EC.hw1.Model.Account;
import com.EC.hw1.Model.BankAccount;
import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;
import com.EC.hw1.Utilities.DAOUtilities;

public class EmployeeDAOImpl implements EmployeeDAO {
	private Connection connection;
	private PreparedStatement stmt;
	
	
	@Override
	public void getAllCustomer(Employee emp) {
		BankAccountDAO dao = DAOUtilities.getBankAccountDAO();
		try{
			connection = DAOUtilities.getConnection();
			String sql = "SELECT UT.U_ID, UT.FIRSTNAME, UT.LASTNAME, UT.USERNAME, UT.PASSWORD, UT.PRIVELEDGE "
						+ "FROM USER_TABLE UT "
						+ "INNER JOIN CUSTOMERS C ON C.C_ID = UT.U_ID "
						+ "WHERE C.E_ID = ?";
			
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, emp.getUser_id());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Customer c = new Customer();
				BankAccount ba = new BankAccount();
				c.setUser_id(rs.getInt("U_ID"));
				c.setFirstName(rs.getString("FIRSTNAME"));
				c.setLastName(rs.getString("LASTNAME"));
				c.setPassword(rs.getString("PASSWORD"));
				c.setUserName(rs.getString("USERNAME"));
				c.setPriveledge(rs.getInt("PRIVELEDGE"));
				ba.setCashAccount(dao.getCheckingAccountValue(c.getUserName()));
				ba.setSavingAccount(dao.getSavingAccountValue(c.getUserName()));
				ba.setCreditAccount(dao.getCreditAccountValue(c.getUserName()));
				ba.setActive(dao.isActive(c.getUserName()));
				ba.setEmail(dao.getEmail(c.getUserName()));
				ba.setLastLogin(dao.getLastLogin(c.getUserName()));
				c.setBankAccount(ba);
				emp.getCustList().add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeResources();
		}
		
	}

	@Override
	public Employee getEmployee(String username) {
		Employee emp = null;
		AccountDAO dao = DAOUtilities.getAccountDAO();
		try{
			connection = DAOUtilities.getConnection();
			String sql = "SELECT U_ID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD, PRIVELEDGE " +
							"FROM USER_TABLE "
							+"WHERE USERNAME = ? AND PRIVELEDGE = 2";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				emp = new Employee();
				Account a = new Account();
				emp.setUser_id(rs.getInt("U_ID"));
				emp.setFirstName(rs.getString("FIRSTNAME"));
				emp.setLastName(rs.getString("LASTNAME"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setUserName(rs.getString("USERNAME"));
				emp.setPriveledge(rs.getInt("PRIVELEDGE"));
				a.setLastLogin(dao.getLastLogin(username));
				emp.setAccount(a);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(emp != null){
				dao.updateLastLogin(emp.getUser_id());
			}
			closeResources();
		}
		return emp;
	}
	

	@Override
	public boolean aproveApplication(int u_id) {
		int update = 0;
		try{
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE BANK_ACCOUNT "
						+ "SET STATUS = 1 "
						+ "WHERE U_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, u_id);
			update = stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			closeResources();
		}
		return (update==3)?true:false; // three accounts should always be approved
	}

	@Override
	public boolean denyApplication(int u_id) {
		int removed = 0;
		try{
			connection = DAOUtilities.getConnection();
			String sql = "DELETE FROM USER_TABLE "
						+"WHERE U_ID = ?";
			//already added on delete cascade to foreign key references
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, u_id);
			removed = stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			closeResources();
		}
		return (removed==0)?false:true;
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
