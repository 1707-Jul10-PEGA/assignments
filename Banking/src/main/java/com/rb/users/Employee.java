package com.rb.users;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Employee extends User {
	
	ArrayList<Customer> customers;
	
	private final ArrayDeque<Customer> applicantQueue 
    	= new ArrayDeque<Customer>();

	private final ArrayDeque<Integer> appTypeQueue
		= new ArrayDeque<Integer>();
	
	
	
	Employee(String name, String password){
		super(1, name, password);
	}
	
	void newCustomer(String name, String pass){
		
		Customer newCust = new Customer(this, name, pass);
		
		customers.add(newCust);
		
	}
	
	void addApplicant(Customer customer, Integer type){
		applicantQueue.add(customer);
		appTypeQueue.add(type);
	}
	
	
	void appDecision(int index, boolean approved){
		Customer customer;
		//int 
		
		if(approved){
			
		}
		
	}
	
	void printCustomers(){
		
		if (customers.isEmpty()) {
			System.out.println("No customers found.");
		} else {
			
			String output = "";
			
			for( int i = 0; i < customers.size(); i++ ) {
				output += "  " + (i + 1) + " - " + customers.get(i).toString() 
					+ "\n";
			}
			
			System.out.println(output);
		}
		
	}
	
}