package com.revature.banking;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class UserFactory {
	private static int User_ID = 0;
	
	public User createUser(String type, String firstName, String lastName, int age, String phone, String address, String username,
			String password, ArrayList<Integer> acctIndex, int customerIndex, int U_ID) {
		Main.Log.trace("UserFactory createUser: Creating User.... " + firstName + " " + lastName);
//		if(U_ID < 1) {
//			U_ID = User_ID;
//			User_ID++;
//		}
		User user = null;
			if("customer".equals(type)) {
				user = new Customer(firstName, lastName, age, phone, address, username,
						password, acctIndex, customerIndex,U_ID);
				
				Main.customerBA.add(user);

			}
			else if("employee".equals(type)) {
				user = new Employee(firstName, lastName, age, phone, address, username,
						password,acctIndex,U_ID);
				Main.employeeBA.add(user);
			}
			else if("admin".equals(type)) {
				user = new Administrator(firstName, lastName, age, phone, address, username,
						password,U_ID);
				Main.adminBA.add(user);
			}
		return user;
	}
	
	public User createUserWithConsoleInput(int customerIndex) {
		Main.Log.trace("UserFactory createUserWithConsoleInput: Creating User with Console.... " );

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
						password, new ArrayList<Integer>(), customerIndex, 0);
				Main.customerBA.add(user);
				Random r = new Random();
				
				/*int employeeIndex = r.nextInt(Main.getEmployeeBA().size());
				Employee e = (Employee) Main.employeeBA.get(employeeIndex);
				ArrayList<Integer> newList = e.getCustomerList();
				newList.add(customerIndex);
				e.setCustomerList(newList);
				Main.employeeBA.set(employeeIndex, e);
				*/
			}
			else if("employee".equals(type)) {
				user = new Employee(firstName, lastName, age, phone, address, username,password,new ArrayList<Integer>(),0);
				Main.employeeBA.add(user);
			}
			else if("admin".equals(type)) {
				user = new Administrator(firstName, lastName, age, phone, address, username,password,0);
				Main.adminBA.add(user);
			}

		return user;
	}
}
