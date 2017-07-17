package com.nc.banking_app.users;

import java.io.Serializable;

public class Employee extends Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private double balance;
	private int memeber;
	
	public Employee(){
		this.name = "EmployeeHasNoName";
		this.type = "Employee";
		this.balance = 0.0;
		this.memeber = 0;
	}
	public Employee(String n, double b, int m){
		this.name = n;
		this.type = "Employee";
		this.balance = b;
		this.memeber = m;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
