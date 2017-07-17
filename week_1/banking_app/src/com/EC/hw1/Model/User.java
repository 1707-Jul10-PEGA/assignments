package com.EC.hw1.Model;

import java.io.Serializable;

public class User implements Serializable,Comparable<User>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1357994648164098083L;
	//private String role;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
		
	public User() {
		super();
	}

	public User(String firstName, String lastName,String userName,String password) {
		super();
		//this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "First Name: " + firstName + "\nLast Name: " + lastName + "\nUsername: " + userName;
	}
	

	@Override
	public int compareTo(User o) {
		if(this instanceof Admin){
			return 1;
		}else if(this instanceof Employee){
			return 0;
		}else{
			return -1;
		}	
	}
	
	
	
	
}
