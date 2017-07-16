package com.revature.bankingapp.entities.person;

import java.util.UUID;

public class Customer extends Person {

	private String customerSince;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstname, String lastName, String username, String dob, String address, UUID userId, String customerSince) {
		super(firstname, lastName, username, dob, address, userId);
		this.customerSince = customerSince;
	}

	public Customer(String firstname, String lastName, String username, String dob, String address,String customerSince) {
		super(firstname, lastName, username, dob, address);
		this.customerSince = customerSince;
	}

	public String getCustomerSince() {
		return customerSince;
	}

	public void setCustomerSince(String customerSince) {
		this.customerSince = customerSince;
	}
	
	
	
}
