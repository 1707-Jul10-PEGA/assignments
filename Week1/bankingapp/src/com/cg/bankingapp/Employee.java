package com.cg.bankingapp;

public class Employee extends User {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1314501009848014266L;

	public Employee(String name, String username, String password) {
		super(name, username, password, "employee");
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() +" Username: "+this.getUsername()+" Password: "+this.getPassword();
	}
}
