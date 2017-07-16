package com.rb.users;

import java.util.ArrayList;
import com.rb.accounts.Account;

public class Customer extends User {
	
	Employee assignedTo;
	ArrayList<Account> accounts;
	
	Customer(Employee assignedTo, String name, String password){
		super(name, password);
		this.assignedTo = assignedTo;
		this.accounts = new ArrayList<Account>();
	}
	
	
	void apply(int accountType){
		
		assignedTo.addApplicant(this, accountType);
		
	}
	
	
	Account accessAccount(int index){
		return accounts.get(index);
	}
	
	void printAccounts(){
		
		if (accounts.isEmpty()) {
			System.out.println("No accounts found. Please apply.");
		} else {
			
			String output = "";
			
			for( int i = 0; i < accounts.size(); i++ ) {
				output += "  " + (i + 1) + " - "+ accounts.get(i).toString() + "\n";
			}
			
			System.out.println(output);
		}
		
	}
	
	@Override
	public String toString(){
		
		return "Username: " + getName() + "Customer ID: " + getUserID() 
			+ "  Managing Employee " + assignedTo.toString();
		
	}
	
}
