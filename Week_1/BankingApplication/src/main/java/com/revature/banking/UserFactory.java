package com.revature.banking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserFactory {
	public User createUser(String type, String firstName, String lastName, int age, String phone, String address, String username,
			String password, ArrayList<Integer> acctIndex, int customerIndex) {
		
		User user = null;
			if("customer".equals(type)) {
				user = new Customer(firstName, lastName, age, phone, address, username,
						password, acctIndex, customerIndex);
				Main.customerBA.add(user);
			}
			else if("employee".equals(type)) {
				user = new Employee(firstName, lastName, age, phone, address, username,
						password,acctIndex);
				Main.employeeBA.add(user);
			}
			else if("admin".equals(type)) {
				user = new Administrator(firstName, lastName, age, phone, address, username,
						password);
				Main.adminBA.add(user);
			}
			
		return user;
	}
	
	public User createUserWithConsoleInput(int customerIndex) {
		
		User user = null;
		String type = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a number for type of account: [1] customer, [2] employee, [3] administrator, anything else to exit");
		int num = Integer.parseInt(input.nextLine());
		if(num == 1) {
			type = "customer";
		}
		else if(num == 2) {
			type = "employee";
		}
		else if(num == 3) {
			type = "admin";
		}
		else {
			System.out.println("Exiting..........");
			return null;
		}
		System.out.println("Please input the following information to create a new account.");
		System.out.println("First Name: ");
		String firstName = input.nextLine();
		System.out.println("Last Name: ");
		String lastName = input.nextLine();
		System.out.println("Age: ");
		int age = Integer.parseInt(input.nextLine());
		System.out.println("Phone: ");
		String phone = input.nextLine();
		System.out.println("Address: ");
		String address = input.nextLine();
		System.out.println("Username:");
		String username = input.nextLine();
		System.out.println("Password:");
		String password = input.nextLine();
			if("customer".equals(type)) {
				user = new Customer(firstName, lastName, age, phone, address, username,
						password, new ArrayList<Integer>(), customerIndex);
				Main.customerBA.add(user);
			}
			else if("employee".equals(type)) {
				user = new Employee(firstName, lastName, age, phone, address, username,password,new ArrayList<Integer>());
				Main.employeeBA.add(user);
			}
			else if("admin".equals(type)) {
				user = new Administrator(firstName, lastName, age, phone, address, username,password);
				Main.adminBA.add(user);
			}
			
		return user;
	}
}
