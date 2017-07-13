package com.EC.hw1.Model;

public class Customer extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016377397393863930L;
	
	private BankAccount bankAccount;
	
	public Customer() {
		super();
	}	
	
	public Customer(String firstName, String lastName, BankAccount bankAccount ){
		super(firstName,lastName);
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}



	
	
	
}
