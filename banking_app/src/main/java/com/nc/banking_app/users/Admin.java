package com.nc.banking_app.users;

import java.io.Serializable;

public class Admin extends Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


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
	public void setType(String type) {
		this.type = type;
	}
	private String name;
	private String type;
	private double balance;
	private int memeber;
	
	
	public Admin(){
		this.name ="AdminHasNoName";
		this.type = "Admin";
		this.balance = 0.0;
		this.memeber = 0;
	}
	public Admin(String n, double b, int m){
		this.name = n;
		this.type = "Admin";
		this.balance = b;
		this.memeber = m;
	}
	
	public String getType() {
		return type;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = this.name + ";" + this.type + ";" + this.balance + ";" + this.memeber + "\r\n";
		return str;
	}
}
