package com.TS.banking.resources;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * Singleton class
 */
public class ConnectionFactory {
	
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory(){
		
	}
	
	public static synchronized ConnectionFactory getInstance(){
		if (build){
			cf = new ConnectionFactory();
		}
		build = false;
		return cf;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("DataSource.properties"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		} catch (SQLException | IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
