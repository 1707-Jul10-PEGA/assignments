package com.cg.bankingapp;

public class Admin extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7616402175313496473L;

	public Admin(String firstname, String lastname, String name, String username, String password) {
		super(firstname, lastname, username, password, "admin");
	}

	@Override
	public String toString() {
		return "[" + this.getFirstname() + " " + this.getLastname() +","+ this.getUsername() +","+ this.getAccessRights() + "]" ;
	}

}
