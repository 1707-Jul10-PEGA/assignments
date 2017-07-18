package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

import com.revature.bankingapp.entities.person.Administrator;
import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.entities.person.Employee;
import com.revature.bankingapp.entities.person.Person;
import com.revature.bankingapp.utils.AuthenticationUtils;
import com.revature.bankingapp.utils.Serializer;

public class CreateAccount {

	Serializer serializer = new Serializer<>();
	
	/*
	 * Create a new system account. Not to be mistaken for an actual bank account.
	 */
	public int newAccountProccess() throws IOException, ClassNotFoundException {

		/* Basic information of a Customer */
		String username = null;
		String password;
		String firstname;
		String lastname;
		String dob;
		String address;
		String customerSince = LocalDate.now().toString();
		String accountType;

		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose a username for your login account");

		while (username == null) {
			String usernameTry = sc.nextLine();

			/* Checks for user name availability */
			while (!AuthenticationUtils.checkUsernameAvailability(usernameTry)) {
				System.out.println("That username is taken. Please try another one " + "or exit pressing 1.");

				if (usernameTry.equals("1")) {
					return -1;
				}

				usernameTry = sc.nextLine();
			}

			username = usernameTry;

			System.out.println("Password: ");
			password = sc.nextLine();

			System.out.println("First Name: ");
		    firstname = sc.nextLine();
			
			System.out.println("Last Name: ");
		    lastname = sc.nextLine();
			
		
			System.out.println("Date of Birth");
			dob = sc.nextLine();

			System.out.println("Address");
			address = sc.nextLine();
			
			System.out.println("What type of account will this be?\n1)Customer\n2)Employee\n3)Administrator");
			accountType = sc.nextLine();
			
			Person p;
			
			
			switch (accountType) {
			case "1":
				p = new Customer(firstname, lastname, username, password, dob, address);
				serializer.persist(p);
				break;

			case "2":
				p = new Employee(firstname, lastname, username, password, dob, address);
				serializer.persist(p);
				break;
				
			case "3":
				p = new Administrator(firstname, lastname, username, password, dob, address);
				serializer.persist(p);
				break;
			default:
				break;
			}
			
			System.out.println("Thank you. Your account has been created. Please login with your credentials");
						
		}
		
		return 1;
	}

}
