package com.cg.bankingapp;

public class Employee extends User {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1314501009848014266L;
	//private int[] customers;

	public Employee(int userid, String firstname, String lastname, String username, String password,int status) {
		super(userid,firstname, lastname, username, password, "employee",status);
		//customers = null;
	}

	public Employee(String firstname, String lastname, String username, String password, int status) {
		super(firstname, lastname, username, password, "employee",status);
	}

	@Override
	public String toString() {
		return "Name: "  + this.getFirstname() + " " + this.getLastname()+" Username: "+this.getUsername()+" Password: "+this.getPassword();
	}
}
