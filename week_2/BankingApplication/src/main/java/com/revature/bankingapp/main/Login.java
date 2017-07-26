package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.AbstractDocument;

import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.entities.user.Employee;
import com.revature.bankingapp.entities.user.SystemUser;

public class Login {

	private int MAX_LOG_IN_ATTEMPTS = 3;
	private int attempts = MAX_LOG_IN_ATTEMPTS;
	private String type = "";

	public int login() throws FileNotFoundException, ClassNotFoundException, IOException {

		Scanner sc = new Scanner(System.in);

		while (!(type.equals("4"))) {
			System.out.println("Are you a customer or employee?");
			System.out.println("1) Customer");
			System.out.println("2) Employee");

			type = sc.nextLine();

			System.out.println("Please enter your credentials (case sensitive) or type 2 to exit:");

			if (type.equals("4")) {
				return -1;
			}

			System.out.println("Username:");

			String username = sc.nextLine();

			System.out.println("Password:");

			String password = sc.nextLine();

			Authentication auth = new Authentication();

			switch (type) {
			case "1":
				Customer c;
				c = auth.customerAuthentication(username, password);

				if (c != null) {
					System.out.println("\nAccess Granted!\n");
					CustomerDashboard dashboard = new CustomerDashboard();
					return dashboard.customerDashboard(c);
					
				} else if (incorrectCredentialsMessage() == -1) {
					return -1;
				}

				break;
			case "2":
				Employee e;
				
				e = auth.employeeAuthentication(username, password);
				
				if (e != null) {
					System.out.println("\nAccess Granted!\n");
					EmployeeDashboard dashboard = new EmployeeDashboard();
					return dashboard.employeeDashboard(e);

				} else if (incorrectCredentialsMessage() == -1) {
					return -1;
				}

				break;

			default:
				break;
			}

		}

		return -1;

	}

	private int incorrectCredentialsMessage() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Incorrect Credentials or User is not in the system.");
		type = "0";
		attempts--;
		if (attempts == 0) {
			System.out.println("You ran out of attempts. System will go into lock down. ");
			return -1;
		} else {
			System.out.println("You have " + attempts + " login attempts left.");
			return 1;
		}
	}

}
