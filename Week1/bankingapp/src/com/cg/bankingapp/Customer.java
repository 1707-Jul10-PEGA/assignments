package com.cg.bankingapp;

public class Customer extends User{
	
	private double balance;

	//Constructor
	public Customer(String name, String username, String password, String userType, double balance) {
		super(name, username, password, userType);
		this.balance = balance;
		
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString(){
		return "Name: " + this.getName() + "[" 
						+ this.getUsername()+ ","
						+ this.getPassword()+ ","
						+ this.getUserType()+ ","
						+ this.getBalance() + "]";
	}
}
	