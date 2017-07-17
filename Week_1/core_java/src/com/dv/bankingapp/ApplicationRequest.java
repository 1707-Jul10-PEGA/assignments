package com.dv.bankingapp;

import java.io.Serializable;

public class ApplicationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7627220935904539518L;
	
	private String userName;
	
	public ApplicationRequest() {
	
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "\n===== Application Request =====\nUsername: " + this.getUserName() + "\n";
	}

}
