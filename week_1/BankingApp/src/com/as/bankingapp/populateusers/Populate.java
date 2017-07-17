package com.as.bankingapp.populateusers;

import java.util.ArrayList;
import java.util.List;

import com.as.bankingapp.admin.Admin;
import com.as.bankingapp.customer.Customer;
import com.as.bankingapp.employee.Employee;
import com.as.bankingapp.filemanager.FileManager;
import com.as.bankingapp.user.User;

public class Populate {

	private static String userFilename = "Users.txt";
			
	/*
	 * Populate the Users.txt data file with a default set of users
	 */
	public static void populate() {
		List<User> defaultUsers = new ArrayList<User>();
		
		//make some default users
		//make the admin
		defaultUsers.add(new Admin("admin", "password"));
		//make 2 employees
		defaultUsers.add(new Employee("thing1", "redfish"));
		defaultUsers.add(new Employee("thing2", "bluefish"));
		//make 5 customers
		defaultUsers.add(new Customer("zack", "dog"));
		defaultUsers.add(new Customer("ricky", "cat"));
		defaultUsers.add(new Customer("frank", "fish"));
		defaultUsers.add(new Customer("chase", "mouse"));
		defaultUsers.add(new Customer("kyle", "bird"));
		//store them in the file
		FileManager.writeOutUsers(userFilename, defaultUsers);
	}
	
}
