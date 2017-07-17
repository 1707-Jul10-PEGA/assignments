package com.users;

import java.io.Serializable;

import com.interfaces.Menu;


public class Admin extends User implements Menu, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6198406213991514241L;

	@Override
	public void displayMenu() {

	}

	@Override
	public boolean optionInput() {
		return false;
	}

	@Override
	public String toString() {
		return "Admin [getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getUserName()="
				+ getUserName() + ", getPassword()=" + getPassword() + ", getAge()=" + getAge() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + "]";
	}
	

}
