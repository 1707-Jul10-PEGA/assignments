package com.WilliamLewis.BankingApp.JDBC.Connection;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionFactory{
		private static ConnectionFactory cf = null;
		private static Boolean build = true;
		private static Logger log = Logger.getRootLogger();
		private ConnectionFactory(){
			
		}
		
		public static synchronized ConnectionFactory getInstance(){
			if(build){
				cf = new ConnectionFactory();
			}
			return cf;
		}
		
		public Connection getConnection(){
			//log.debug("Starting connection");
			Connection conn = null;
			Properties prop = new Properties();
			//log.debug("Attempting to read Properties file.");
			System.out.println("hello");
			try{
				
			FileWriter fw = new FileWriter("test.txt");
			fw.write("hello");
			fw.flush();
			
			prop.load(new FileReader("./datasource.properties"));
			//C:\\Users\\William\\assignments\\week_1\\core_java\\WilliamLBankingAPp\\src\\datasource.properties
			//C:/Users/William/assignments/week_1/core_java/WilliamLBankingAPp/src/datasource.properties
			//C://Users//William//assignments//week_1//core_java//WilliamLBankingAPp//src//datasource.properties
			//datasource.properties
			//log.debug("Successfully read Properties file.");
																					
		} catch(IOException e1){
			e1.printStackTrace();
			log.debug("Failed to read Props file");}
		
		try{
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"), 
					prop.getProperty("password"));
		//	log.debug("Read URL and login");
		} catch(SQLException e){
			log.debug("Faild to read url username or password for database");
			e.printStackTrace();
		}
		return conn;
		}
		
		
		
	}


