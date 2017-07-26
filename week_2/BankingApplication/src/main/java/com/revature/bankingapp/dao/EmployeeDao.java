package com.revature.bankingapp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.bankingapp.dao.interfaces.EmployeeDaoInterface;
import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.entities.user.Employee;
import com.revature.bankingapp.entities.user.SystemUser;
import com.revature.bankingapp.utils.ConnectionFactory;

public class EmployeeDao implements EmployeeDaoInterface {
	
	Connection conn = null;
	ResultSet resultSet = null;
	ConnectionFactory connFactory = null;
	
	
	@Override
	public void setup() throws FileNotFoundException, IOException {
		connFactory = ConnectionFactory.getInstance();		
	}

	public EmployeeDao() {
		// TODO Auto-generated constructor stub
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
	
	@Override
	public Employee getMyAssignedBanker(UUID employeeId) {
		
		Employee employee;
				
		conn = connFactory.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = '" + employeeId + "'";
		Statement statement;
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		while(resultSet.next()) {
//			int accessLevel = Integer.parseInt(resultSet.getString("ACCESS_LEVEL"));
//			
//		}
		
		
		return null;
	}
	
	public Employee getEmployeeById(UUID employeeId) {
		
		SystemUserDao sud = new SystemUserDao();
		
		SystemUser employeeUser;
		
		conn = connFactory.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = '" + employeeId + "'";
		Statement statement;
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				employeeUser = sud.getSysteUserById(employeeId);
				int accessLevel = Integer.parseInt(resultSet.getString("ACCESS_LEVEL"));
				Employee e = new Employee(employeeUser, employeeId, accessLevel);
												
				conn.close();
				//LOG FOUND								
				return e;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
		return null;
	}
	
	
	
}
