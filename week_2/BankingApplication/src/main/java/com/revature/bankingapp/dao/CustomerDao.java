package com.revature.bankingapp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.bankingapp.dao.interfaces.CustomerDaoInterface;
import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.entities.user.SystemUser;
import com.revature.bankingapp.utils.ConnectionFactory;

public class CustomerDao implements CustomerDaoInterface {

	Connection conn = null;
	ResultSet resultSet = null;
	ConnectionFactory connFactory = null;

	@Override
	public boolean isCustomer(UUID id) throws SQLException {
		// TODO Auto-generated method stub
		return isCustomer(id.toString());
	}

	@Override
	public boolean isCustomer(String id) throws SQLException {
		// TODO Auto-generated method stub

		conn = connFactory.getConnection();
		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = '" + id + "'";
		Statement statement = conn.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			conn.close();
			return true;
		}

		conn.close();
		return false;
	}
	
	@Override
	public Customer getCustomerById(String id) throws SQLException {
		// TODO Auto-generated method stub
		conn = connFactory.getConnection();
		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = '" + id + "'";
		Statement statement = conn.createStatement();
		resultSet = statement.executeQuery(sql);
		
		if (resultSet.next()) {
			String customer_id = resultSet.getString("CUSTOMER_ID");
			String banker_id = resultSet.getString("BANKER_ID");
			Customer c = new Customer(customer_id, banker_id);
			c.setUserId(UUID.fromString(customer_id));
			conn.close();
			//LOG FOUND
			
			
			return c;
		}
		//LOG NOT FOUND
		conn.close();
		return null;
		
	}
	
	public Customer getCustomerById(UUID id, SystemUser parent) throws SQLException {
		return getCustomerById(id.toString(),parent);
	}
	
	public Customer getCustomerById(String id, SystemUser parent) throws SQLException {
		// TODO Auto-generated method stub
		conn = connFactory.getConnection();
		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = '" + id + "'";
		Statement statement = conn.createStatement();
		resultSet = statement.executeQuery(sql);
		
		if (resultSet.next()) {
			String customerId = resultSet.getString("CUSTOMER_ID");
			String bankerId = resultSet.getString("BANKER_ID");
			Customer c = new Customer(parent, customerId, bankerId);
			conn.close();
			//LOG FOUND
			
			
			return c;
		}
		//LOG NOT FOUND
		conn.close();
		return null;
		
	}

	@Override
	public Customer getCustomerById(UUID id) throws SQLException {
		// TODO Auto-generated method stub
		return getCustomerById(id.toString());
	}

	@Override
	public void setup() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		connFactory = ConnectionFactory.getInstance();
	}
	
	public CustomerDao() {
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

	


}
