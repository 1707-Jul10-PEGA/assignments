package com.revature.bankingapp.entities.person;

import java.util.UUID;

/*
 * Does everything that an employee does
 * and more. It is more specialized.
 */
public class Administrator extends Employee {

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Administrator(String firstname, String lastName, String username, String password, String dob,
			String address, UUID userId) {
		super(firstname, lastName, username, password, dob, address, userId);
		// TODO Auto-generated constructor stub
	}



	public Administrator(String firstname, String lastName, String username, String password, String dob,
			String address) {
		super(firstname, lastName, username, password, dob, address);
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return super.toString();
	}

	
	

}
