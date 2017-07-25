package com.dv.bankingapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Driver {

	// one scanner than can be referenced through all classes
	public static final Scanner read = new Scanner(System.in);
	
	// one service logger
	public static Service serviceLog = new Service();
	
	// one connection to the database
	public static Connection conn = null;
	
	// one static user after login prompt
	public static User authUser = null;

	public static void setupConnection() {
		conn = ConnectionFactory.getInstance().getConnection();
	}

	public static void main(String[] args) {
		Login login = new Login();
		Dashboard dashboard = new Dashboard();
		
		// setup a single connection to the database
		setupConnection();
		
		// prompt the user at login
		login.prompt();
		
		if(authUser != null) {
			System.out.println("===== Welcome " + authUser.getUserName() + " =====");

			try {
				dashboard.prompt();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else {
			System.out.println("\nInvalid authentication. Exiting ...");
		}
		
		read.close();
		System.out.println("Successfully exited.");
	}

}