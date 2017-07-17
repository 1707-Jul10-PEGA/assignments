package com.dv.bankingapp;

import java.io.Serializable;

abstract public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1557053905971757924L;

	private String userName;
	private String pw;
	private String type;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	abstract public void viewAccount();

	@Override
	public String toString() {
		return "\nAccount Type: " + this.type + "\nUsername: " + this.getUserName() + "\n";
	}
}
