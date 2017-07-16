package com.rb.users;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Employee extends User {
	
	ArrayList<Customer> customers;
	
	private final ArrayDeque<Customer> applicantQueue 
    	= new ArrayDeque<Customer>();

	private final ArrayDeque<Integer> appTypeQueue
		= new ArrayDeque<Integer>();
	
	
	
	public Employee(){
		super(1);
	}
	
	public void addApplicant(Customer customer, Integer type){
		applicantQueue.add(customer);
		appTypeQueue.add(type);
	}
	
	
	
}
