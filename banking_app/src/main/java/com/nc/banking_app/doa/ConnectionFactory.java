package com.nc.banking_app.doa;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory cf = null;
	private static boolean build = true;
	
	private ConnectionFactory(){
		
	}
	
	public static synchronized ConnectionFactory getInstance(){
		if (build){
			cf = new ConnectionFactory();
		}
		return cf;
	}
	public static Connection getConnection(){
		Connection conn = null;
		Properties prop = new Properties();
		
		try{
			prop.load(new FileReader("datasource.properties"));
		} catch (IOException e1){
			e1.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("password"));
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}

}
