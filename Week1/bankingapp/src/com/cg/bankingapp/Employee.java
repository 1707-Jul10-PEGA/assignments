package com.cg.bankingapp;

public class Employee extends User {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1314501009848014266L;

	public Employee(String firstname, String lastname, String username, String password) {
		super(firstname, lastname, username, password, "employee");
	}

	@Override
	public String toString() {
		return "Name: " + this.getFirstname() + " " + this.getLastname() +" Username: "+this.getUsername()+" Password: "+this.getPassword();
	}
}
