package com.nc.banking_app.actions;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.nc.banking_app.doa.LoginDOA;
import com.nc.banking_app.users.UserFactory;
import com.nc.banking_app.users.Users;

public class StartingApp  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Scanner sc = new Scanner(System.in);
	private UserFactory userFactory = new UserFactory();
	private LoadData ld = new LoadData();
	private LoginDOA logDOA = new LoginDOA();

	public int control(Connection conn) throws IOException, NumberFormatException, ClassNotFoundException {
		String userInput = "P";
		int currentUser = -1;
		

		// Loop until user is logging in
		while (currentUser == -1) {
			System.err.println("Login(L) or Registor(R)");
			userInput = sc.nextLine();
			// Login
			if ("L".equalsIgnoreCase(userInput)) {
				//currentUser = findUser(myList);
				currentUser = logDOA.login(conn);
			// Registor
			} else if ("R".equalsIgnoreCase(userInput)) {
				//Create new user
				//newUser(myList);
				logDOA.registor(conn);
			}
		}
		// Selected user index
		return currentUser;
	}

	// Login
	public int findUser(List<Users> myList) {
		// Get name
		System.out.println("What is your name? ");
		String name = sc.nextLine();

		// Look through a list of all users
		for (int x = 0; x < myList.size(); x++) {
			if (name.equalsIgnoreCase(myList.get(x).getName())) {
				// User found
				return x;
			}
		}
		// No user found
		return -1;
	}

	// Registration
	public void newUser(List<Users> myList) throws IOException, NumberFormatException, ClassNotFoundException {
		String name = new String();
		// Get name
		while (name.isEmpty()) {
			System.out.println("What is your name? ");
			name = sc.nextLine();
		}
		//Create user object
		Users newUser = userFactory.getType("CUSTOMER", name, 0.0, 0);
		//Add user to list
		myList.add(newUser);
		//Write user to user txt
		ld.listToFile(myList);
		ld.fileToList(myList);
	}
}
