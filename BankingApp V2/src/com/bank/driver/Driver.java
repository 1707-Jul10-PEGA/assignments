package com.bank.driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bank.admin.Admin;
import com.bank.customer.Customer;
import com.bank.dao.BankDAOImpl;
import com.bank.employee.Employee;
import com.bank.menu.StartingMenuClass;
import com.bank.user.User;
import com.bank.util.ConnectionFactory;



public class Driver {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Welcome to Wendell's Bank!");
	
		ArrayList<Admin> admins = new ArrayList<Admin>();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<String[]> toApp = new ArrayList<String[]>();
		
		//open and test connection
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection myConn = cf.getConnection();
		
		try {
			System.out.println(myConn.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		BankDAOImpl dao = new BankDAOImpl();
		//read in from database
		try {
			
			List<User> allUsers = dao.getAllUsers();
			for(int u = 0; u < allUsers.size(); u++){
				if(allUsers.get(u).getPosition().equals("employee")){
					//user_id, first, last, username, u_pass, for only here add position
					employees.add(new Employee(	allUsers.get(u).getDb_id(),
												allUsers.get(u).getfName(),
												allUsers.get(u).getlName(),
												allUsers.get(u).getuName(),
												allUsers.get(u).getPass(),
												allUsers.get(u).getPosition()));
				}
				if(allUsers.get(u).getPosition().equals("customer")){
					customers.add(new Customer (allUsers.get(u).getDb_id(),
												allUsers.get(u).getfName(),
												allUsers.get(u).getlName(),
												allUsers.get(u).getuName(),
												allUsers.get(u).getPass(),
												allUsers.get(u).getPosition()));
				}
				if(allUsers.get(u).getPosition().equals("admin")){
					admins.add(new Admin (	allUsers.get(u).getDb_id(),
											allUsers.get(u).getfName(),
											allUsers.get(u).getlName(),
											allUsers.get(u).getuName(),
											allUsers.get(u).getPass(),
											allUsers.get(u).getPosition()));
				}
			}
			
			
			Statement stmt = myConn.createStatement();
			//System.out.println(customers.get(0).getDb_id());
			//dao.newBankAccount(customers.get(0).getDb_id());
			stmt.close();
			myConn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StartingMenuClass sMC = new StartingMenuClass();
		sMC.menuHandler(admins, employees, (ArrayList<Customer>) customers, toApp);
	
	}
	
}
