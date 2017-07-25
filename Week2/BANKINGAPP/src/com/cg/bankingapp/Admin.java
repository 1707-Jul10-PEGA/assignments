package com.cg.bankingapp;

public class Admin extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7616402175313496473L;

	public Admin(int userid, String firstname, String lastname, String username, String password, int status) {
		super(userid, firstname, lastname, username, password, "admin",status);
	}

	@Override
	public String toString() {
		return "[" + this.getFirstname() + " "+this.getLastname() +","+ this.getUsername() +","+ this.getAccessRights() + "]" ;
	}

}
