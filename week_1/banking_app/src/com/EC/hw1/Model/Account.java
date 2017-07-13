package com.EC.hw1.Model;

import java.util.Date;

public class Account {

	private String email;
	private String userName;
	private String password;
	private Date lastLogin;
	
	public Account(){
		super();
	}
	
	public Account(String userName, String email, String password, Date lastLogin){
		setUserName(userName);
		setEmail(email);
		setPassword(password);
		setLastLogin(lastLogin);
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}	
	
}
