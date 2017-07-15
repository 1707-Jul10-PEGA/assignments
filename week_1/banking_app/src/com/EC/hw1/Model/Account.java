package com.EC.hw1.Model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2873087415539944901L;
	private String email;
	private String lastLogin;
	
	public Account(){
		super();
	}
	
	public Account(String email){
		setEmail(email);
		setLastLogin();
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/  HH:mm:ss");
		this.lastLogin = dateFormat.format(new Date()) ;
	}	
	
}
