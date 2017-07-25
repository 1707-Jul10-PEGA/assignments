package com.EC.hw1.Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.EC.hw2.DAO.AccountDAO;
import com.EC.hw2.DAO.AccountDAOImpl;
import com.EC.hw2.DAO.AdminDAO;
import com.EC.hw2.DAO.BankAccountDAO;
import com.EC.hw2.DAO.BankAccountDAOImpl;
import com.EC.hw2.DAO.CustomerDAO;
import com.EC.hw2.DAO.CustomerDAOImpl;
import com.EC.hw2.DAO.EmployeeDAO;
import com.EC.hw2.DAO.EmployeeDAOImpl;
import com.EC.hw2.DAO.UserDAO;
import com.EC.hw2.DAO.UserDAOImpl;

public class DAOUtilities {
	
	private static Connection connection;
	
	
	public static synchronized Connection getConnection()throws SQLException{
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("datasource.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(connection == null){
			connection = DriverManager.getConnection(url,username,password);	
		}
		//If connection was closed then retrieve a new connection
		if(connection.isClosed()){
			connection = DriverManager.getConnection(url,username,password);
		}
		return connection;
	}
	
	public static BankAccountDAO getBankAccountDAO(){
		return new BankAccountDAOImpl();
	}
	
	public static AccountDAO getAccountDAO(){
		return new AccountDAOImpl();
	}
	
	public static CustomerDAO getCustomerDAO(){
		return new CustomerDAOImpl();
	}
	
	public static EmployeeDAO getEmployeeDAO(){
		return new EmployeeDAOImpl();
	}
	
	public static AdminDAO getAdminDAO(){
		return new AdminDAOImpl();
	}
	
	public static UserDAO getUserDAO(){
		return new UserDAOImpl();
	}
	
}
