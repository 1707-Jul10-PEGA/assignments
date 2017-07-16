package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;
import java.time.*;

import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.utils.AuthenticationUtils;
import com.revature.bankingapp.utils.SerializePerson;

public class CreateAccount {
	
	/*Create a new system account. Not to be mistaken for an actual
	 * bank account.*/
	public int newAccountProccess() throws  IOException {
		
		/*Basic information of a Customer*/
		String username = null;
		String password;
		String firstname;
		String lastName;
		String dob;
		String address;
		String customerSince = LocalDate.now().toString();
	    
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose a username for your login account");
		
		while(username == null) {
			String usernameTry = sc.nextLine();
			
			/*Checks for user name availability*/
			while(!AuthenticationUtils.checkUsernameAvailability(usernameTry)) {
				System.out.println("That username is taken. Please try another one "
						+ "or exit pressing 1.");
				
				if(usernameTry.equals("1")) {
					return -1;
				}
				
				usernameTry = sc.nextLine();
			}
			
			username = usernameTry;
						
			System.out.println("Password: ");
			password = sc.nextLine();
			
			System.out.println("Name: ");
			String fullname = sc.nextLine();
			String[] composedName = fullname.split(" ");
			firstname = composedName[0];
			lastName = composedName[1];
			
			System.out.println("Date of Birth");
			dob = sc.nextLine();
			
			System.out.println("Address");
			address = sc.nextLine();
			
			System.out.println("Thank you. Your account has been created. Please login with your credentials");
			
			/*Create new customer*/
			Customer newCustomer = new Customer(firstname, lastName, username, dob, address, customerSince);
			
			//Store it into txt file
			SerializePerson serializer = new SerializePerson();
			serializer.writePerson(newCustomer);
			return 1;
		}
			
		return 1;
	}
	
	
	
	

}
