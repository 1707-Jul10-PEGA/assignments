package com.revature.bankingapp.entities.user;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

import com.revature.bankingapp.entities.account.BankAccount;


public class Customer extends SystemUser{

	private UUID customerId;
	private UUID bankerId;
	
	public Customer() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerId, String bankerId) {
		super();
		this.customerId = UUID.fromString(customerId);
		this.bankerId = UUID.fromString(bankerId);
		// TODO Auto-generated constructor stub
	}

	
	public Customer(String firstname, String lastname, String username, String password, String dob, String address,
			String userId,String bankerId) {
		super(firstname, lastname, username, password, dob, address, userId);
		this.customerId = UUID.fromString(userId);
		this.customerId = UUID.fromString(bankerId);
	}
	
	
	public Customer(String firstname, String lastname, String username, String password, String dob, String address,
			String userId) {
		super(firstname, lastname, username, password, dob, address, userId);
		this.customerId = UUID.fromString(userId);
		this.bankerId = null;
	}
	

	public Customer(String firstname, String lastname, String username, String password, String dob, String address,
			UUID userId,UUID bankerId) {
		super(firstname, lastname, username, password, dob, address, userId);
		this.customerId = userId;
		this.bankerId = bankerId;
	}
	
	public Customer(String firstname, String lastname, String username, String password, String dob, String address,
			UUID userId) {
		super(firstname, lastname, username, password, dob, address, userId);
		this.customerId = userId;
		this.bankerId = null;
	}

	public Customer(String firstname, String lastname, String username, String password, String dob, String address) {
		super(firstname, lastname, username, password, dob, address);
		this.customerId = UUID.randomUUID();
		this.bankerId = null;
		super.setUserId(this.customerId);
	}

	public Customer(SystemUser parent,UUID customerId, UUID bankerId) {
		super(parent.getFirstname(),parent.getFirstname(),parent.getUsername(),parent.getPassword(),parent.getDob(),parent.getAddress(),customerId);
		this.customerId = customerId;
		this.bankerId = bankerId;
	}
	
	public Customer(SystemUser parent,String customerId, String bankerId) {
		super(parent.getFirstname(),parent.getFirstname(),parent.getUsername(),parent.getPassword(),parent.getDob(),parent.getAddress(),customerId);
		this.customerId = UUID.fromString(customerId);
		this.bankerId = UUID.fromString(bankerId);
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public UUID getBankerId() {
		return bankerId;
	}

	public void setBankerId(UUID bankerId) {
		this.bankerId = bankerId;
	}

	@Override
	public String toString() {
		return super.toString() + "\n"
				+ "Customer ID: " + customerId + ""
				+ "\nBanker ID: " + bankerId;
	}
	
	
	

	
	
}
