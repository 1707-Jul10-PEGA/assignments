package com.rb.accounts;

import com.rb.users.Customer;

public class Savings extends Account {
	
	public Savings(Customer cust){
		setType(2);
		setInterestRate(0.05);
	}
	
}
