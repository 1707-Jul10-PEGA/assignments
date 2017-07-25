package com.dv.bankingapp;

import java.sql.SQLException;

abstract public class User {

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
	
	/* viewUserInfo
	 * query and view the general information about the user
	 */
	abstract public void viewUserInfo() throws SQLException;
	
	/* viewAccount
	 * view account information for specific user
	 */
	abstract public void viewAccount() throws SQLException;

	@Override
	public String toString() {
		return "\nAccount Type: " + this.type + "\nUsername: " + this.getUserName() + "\n";
	}
}
