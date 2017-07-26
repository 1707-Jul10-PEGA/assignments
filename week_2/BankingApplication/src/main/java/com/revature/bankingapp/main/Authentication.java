package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.entities.user.Employee;
import com.revature.bankingapp.entities.user.SystemUser;
import com.revature.bankingapp.dao.CustomerDao;
import com.revature.bankingapp.dao.EmployeeDao;
import com.revature.bankingapp.dao.SystemUserDao;

public class Authentication {

	SystemUserDao userdao = new SystemUserDao();
	CustomerDao customerdao = new CustomerDao();
	EmployeeDao employeedao = new EmployeeDao();
	
	public <T> Customer customerAuthentication(String username, String password)
			throws FileNotFoundException, IOException {

		SystemUser user = null;
		Customer c = null;
					
		try {
			
			user  = userdao.getUserByUsername(username);

			/*If there is a system user by this username, then return the customer associated 
			 * to this username if there is one*/
			if (user != null) {
				
				UUID userid = user.getUserId();
								
				c = customerdao.getCustomerById(userid,user);				
					
				if (user.getPassword().equals(password)) {
					return c;
				} else
					return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;

	}
	
	public <T> Employee employeeAuthentication(String username, String password)
			throws FileNotFoundException, IOException {

		SystemUser user = null;
		Employee employee = null;
					
		try {
			
			user  = userdao.getUserByUsername(username);

			/*If there is a system user by this username, then return the customer associated 
			 * to this username if there is one*/
			if (user != null) {
				
				UUID userid = user.getUserId();
								
				employee = employeedao.getEmployeeById(userid);
					
				if (user.getPassword().equals(password)) {
					return employee;
				} else
					return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;

	}

	private SystemUser getUserType(UUID userid) {
		// TODO Auto-generated method stub
		
		return null;
	}

	
}
