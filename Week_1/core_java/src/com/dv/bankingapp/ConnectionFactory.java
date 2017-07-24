package com.dv.bankingapp;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory cf = null;
	private static Boolean cfExists = false;
	
	private ConnectionFactory() { }
	
	public static synchronized ConnectionFactory getInstance() {
		if(!cfExists) {
			cf = new ConnectionFactory();
			cfExists = true;
		}
		
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();

		try {
			prop.load(new FileReader("datasource.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// get each property from the loaded file
		try {
			conn = DriverManager.getConnection(prop.getProperty("url"), 
					prop.getProperty("username"),
					prop.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
