package com.bank.factory;

import com.bank.employee.Employee;

public class Checking implements BankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2907376091733061621L;
	private static String checkID = "C" + (int)(Math.random() * 1000000);
	private double balance;
	private Employee starter;
	
	

	public Employee getStarter() {
		return starter;
	}

	public void setStarter(Employee starter) {
		this.starter = starter;
	}

	@Override
	public String getID() {
		return checkID;
	}
	
	@Override
	public double viewBalance() {
		return balance;
	}

	@Override
	public void withdraw(double amount) {
		setBalance(getBalance() - amount);

	}

	@Override
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Checking(String checkID, double balance) {
		super();
		Checking.checkID = checkID;
		this.setBalance(balance);
	}
	
	public Checking(){
		super();
	}

	@Override
	public Employee getNameOfStarter() {
		// TODO Auto-generated method stub
		return getStarter();
	}

}
