package com.dv.bankingapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	// one scanner than can be referenced through all classes
	public static final Scanner read = new Scanner(System.in);
	
	// loads list of users from file and adds to it per user
	public static List<User> userList = new ArrayList<User>();

	// loads list of application requests from file and adds to it
	public static List<ApplicationRequest> appRequestList = new ArrayList<ApplicationRequest>();

	// one serializable object that reads and writes to users.txt
	public static SerializeUser serialUser = new SerializeUser();
	
	// one serializable object that reads and writes to apps.txt
	public static SerializeApplicationRequest serialAppRequest = new SerializeApplicationRequest();
	
	// one service logger
	public static Service serviceLog = new Service();
	
	public static void loadLists() {
		userList = serialUser.readUserList();
		appRequestList = serialAppRequest.readAppRequestList();
	}

	public static void createDataFiles() {
		File usersFile = new File("src/com/dv/bankingapp/users.txt");
		File appsFile = new File("src/com/dv/bankingapp/apps.txt");

		// create a users file if it does not exist already
		if(!(usersFile.exists())) {
			try {
				usersFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// create an apps file if it does not exist already
		if(!(appsFile.exists())) {
			try {
				appsFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		User authUser;
		Login login = new Login();
		Dashboard dashboard = new Dashboard();
		
		createDataFiles();
		loadLists();

		authUser = login.prompt();
		
		if(authUser != null) {
			System.out.println("===== Welcome " + authUser.getUserName() + " =====");
			dashboard.prompt(authUser);
		}
		
		else {
			System.out.println("\nInvalid authentication. Exiting ...");
		}
		
		read.close();
		System.out.println("Successfully exited.");
	}

}
