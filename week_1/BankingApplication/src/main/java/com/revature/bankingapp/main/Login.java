package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.AbstractDocument;

import com.revature.bankingapp.entities.person.Administrator;
import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.entities.person.Employee;
import com.revature.bankingapp.entities.person.Person;

public class Login {

	private int loginAttempts = 0;
	
	public void login() throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		String type = "";

		System.out.println("Please enter your credentials:");

		System.out.println("Username:");

		String username = sc.nextLine();

		System.out.println("Password:");

		String password = sc.nextLine();
		
		while(!(type.equals("1") || type.equals("2") || type.equals("3") || type.equals("4")) ) {
			System.out.println("What type of user are you?\n1)Customer\n2)Employee\n3)Administrator\n4)Exit Program");
			type = sc.nextLine();
		}		
		
		Authentication auth = new Authentication();

		switch (type) {
		case "1":
			Customer c = (Customer) auth.userAuthentication(username, password, "customer");
			if(c != null) {
				CustomerDashboard cd = new CustomerDashboard();
				cd.customerDashboard(c);
			}
			break;

		case "2":
			auth.userAuthentication(username, password,"employee");
			break;

		case "3":
			auth.userAuthentication(username, password, "admin");
			break;
			
		case "exit":

			break;

		default:
			break;
		}

	}

}
