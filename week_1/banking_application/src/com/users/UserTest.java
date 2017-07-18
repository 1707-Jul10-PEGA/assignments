package com.users;

import java.io.FileNotFoundException;
import java.util.Set;

import org.apache.log4j.Logger;

public class UserTest {

	private static Logger log = Logger.getRootLogger();
	public static void main(String[] args) {
		AllUsers.getInstance();
		
		Set<User> l1 = AllUsers.users.get(AllUsers.CUSTOMER_INDEX);
		
		l1.add(new Customer());
		l1.add(new Customer());
		l1.add(new Customer());
		l1.add(new Customer());
		l1.add(new Customer());
		l1.add(new Customer());
		l1 = AllUsers.users.get(AllUsers.ADMIN_INDEX);
		l1.add(new Admin());
		l1 = AllUsers.users.get(AllUsers.EMPLOYEE_INDEX);
		l1.add(new Employee());
		l1.add(new Employee());
		l1.add(new Employee());
		AllUsers.writeAllUsers();
		
		try {
			AllUsers.readAllUsers();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.fatal("Trying to load user database from non-existant file 3");
			e.printStackTrace();
		}
		for(User x : AllUsers.users.get(AllUsers.CUSTOMER_INDEX)){
			for(Customer.Account ac : ((Customer)x).accountBalances){
				ac.addBalance(20.0);
			}
			System.out.println(x);
			
		}
		for(User x : AllUsers.users.get(AllUsers.ADMIN_INDEX)){
			System.out.println(x);
		}

	}

}
