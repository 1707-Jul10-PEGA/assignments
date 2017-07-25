package com.nc.banking_app.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Users  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private List<Account> account= new ArrayList<Account>();

	public Customer() {
		this.name = "CustomerHasNoName";
		this.type = "Customer";
	}

	public Customer(String n, double b, int m) {
		this.name = n;
		this.type = "Customer";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccount(){
		return account;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = this.name + ";" + this.type + ";" + this.account.toString() + "\r\n";
		return str;
	}

}
