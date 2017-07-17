package com.revature.bankingapp.entities.person;

import java.util.ArrayList;
import java.util.UUID;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.entities.account.CheckingAccount;
import com.revature.bankingapp.entities.account.SavingsAccount;

public class Customer extends Person {

	private String customerSince;
	private SavingsAccount saving;
	private CheckingAccount checking;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstname, String lastName, String username,String password, String dob, String address, UUID userId, String customerSince) {
		super(firstname, lastName, username, password,dob, address, userId);
		this.customerSince = customerSince;
	}

	public Customer(String firstname, String lastName, String username, String password,String dob, String address,String customerSince) {
		super(firstname, lastName, username, password,dob, address);
		this.customerSince = customerSince;
	}

	public String getCustomerSince() {
		return customerSince;
	}

	public void setCustomerSince(String customerSince) {
		this.customerSince = customerSince;
	}

	@Override
	public String toString() {
		return super.toString() 
				+ "Customer Since: " + this.customerSince + "\n\n";
	}

	public SavingsAccount getSaving() {
		return saving;
	}

	public void setSaving(SavingsAccount saving) {
		this.saving = saving;
	}

	public CheckingAccount getChecking() {
		return checking;
	}

	public void setChecking(CheckingAccount checking) {
		this.checking = checking;
	}

	
	
	
	
	
}
