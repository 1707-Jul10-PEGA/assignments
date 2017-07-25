package com.MS.OJDBC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory cf=null;
	private static Boolean build = true;
	
	private ConnectionFactory()
	{
		
	}
	
	public static synchronized ConnectionFactory getInstance()
	{
		if(build)
		{
			cf = new ConnectionFactory();
		}
		return cf;
	}

	public Connection getConnection()
	{
		Connection conn = null;
		
		Properties prop = new Properties();

		try {
			prop.load(new FileReader("datasource.properties"));
			//System.out.println(prop);
			conn = DriverManager.getConnection(
					prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}