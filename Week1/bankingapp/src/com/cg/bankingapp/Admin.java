package com.cg.bankingapp;

public class Admin extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7616402175313496473L;

	public Admin(String name, String username, String password) {
		super(name, username, password, "admin");
	}

	@Override
	public String toString() {
		return "[" + this.getName() +","+ this.getUsername() +","+ this.getAccessRights() + "]" ;
	}

}
