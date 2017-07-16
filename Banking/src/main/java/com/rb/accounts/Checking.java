package com.rb.accounts;

import com.rb.users.Customer;

public class Checking extends Account {
	
	public Checking(Customer cust){
		setType(1);
		setInterestRate(0.025);
		
	}
	
}
