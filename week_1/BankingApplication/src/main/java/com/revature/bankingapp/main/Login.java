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
			
			Customer c = (Customer) auth.userAuthentication(username, password,"customer");
			if(c != null) {
				System.out.println("Access Granted!\n");
				CustomerDashboard cd = new CustomerDashboard();
				cd.customerDashboard(c);
			}
			break;

		case "2":
			Employee e = (Employee) auth.userAuthentication(username, password,"employee");
			if(e != null) {
				System.out.println("Access Granted!\n");
				EmployeeDashboard ed = new EmployeeDashboard();
				ed.dashboard(e);				
			}
			break;

		case "3":
			Administrator a = (Administrator) auth.userAuthentication(username, password,"administrator");
			if(a != null) {
				System.out.println("Access Granted!\n");
				AdministratorDashboard ad = new AdministratorDashboard();
				ad.dashboard(a);				
			}
			break;

			
		case "exit":

			break;

		default:
			break;
		}

	}

}
