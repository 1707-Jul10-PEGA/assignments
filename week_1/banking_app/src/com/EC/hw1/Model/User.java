package com.EC.hw1.Model;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1357994648164098083L;
	//private String role;
	private String firstName;
	private String lastName;
	
		
	public User() {
		super();
	}

	public User(String firstName, String lastName) {
		super();
		//this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
//	public String getRole() {
//		return role;
//	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	
}
