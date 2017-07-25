package com.nc.banking_app.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private List<Account> account= new ArrayList<Account>();

	public Admin(){
		this.name ="AdminHasNoName";
		this.type = "Admin";
	}
	public Admin(String n, double b, int m){
		this.name = n;
		this.type = "Admin";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Account> getAccount(){
		return account;
	}

	
	
	
	
	public String getType() {
		return type;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = this.name + ";" + this.type + "\r\n";
		return str;
	}
}
