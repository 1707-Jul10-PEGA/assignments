package com.nc.banking_app.users;

import java.io.Serializable;

public class Account  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accName;
	private int active;
	private int type;
	private double balance;
	

	
	public Account(String input) {
		// TODO Auto-generated constructor stub
		accName = input;
		active = 0;
		balance = 0.0;
		type = 0;
	}


	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String name) {
		this.accName = name;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		String str = accName + ";" + balance + ";" + active + ";";
		// TODO Auto-generated method stub
		return str;
	}
}
