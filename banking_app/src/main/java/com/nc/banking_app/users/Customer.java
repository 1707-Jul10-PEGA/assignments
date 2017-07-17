package com.nc.banking_app.users;

import java.io.Serializable;

public class Customer extends Users  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private double balance;
	private int memeber;

	public Customer() {
		this.name = "CustomerHasNoName";
		this.type = "Customer";
		this.balance = 0.0;
		this.memeber = 0;
	}

	public Customer(String n) {
		this.name = n;
		this.type = "Customer";
		this.balance = 0.0;
		this.memeber = 0;
	}

	public Customer(String n, double b, int m) {
		this.name = n;
		this.type = "Customer";
		this.balance = b;
		this.memeber = m;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getMemeber() {
		return memeber;
	}

	public void setMemeber(int memeber) {
		this.memeber = memeber;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = this.name + ";" + this.type + ";" + this.balance + ";" + this.memeber + "\r\n";
		return str;
	}

}
