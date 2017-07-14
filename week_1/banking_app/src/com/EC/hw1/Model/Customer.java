package com.EC.hw1.Model;

public class Customer extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016377397393863930L;
	
	private BankAccount bankAccount;
	private boolean active;
	
	
	public Customer() {
		super();
	}	
	
	public Customer(String firstName, String lastName, String userName, BankAccount bankAccount ){
		super(firstName,lastName,userName);
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Customer [bankAccount=" + bankAccount + ", active=" + active + "]";
	}
	
	

	

	
	
	
}
