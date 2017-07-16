package com.rb.users;

import java.util.ArrayList;
import com.rb.accounts.Account;

public class Customer extends User {
	
	Employee assignedTo;
	ArrayList<Account> accounts;
	
	public Customer(Employee assignedTo){
		this.assignedTo = assignedTo;
		this.accounts = new ArrayList<Account>();
	}
	
	
	void apply(int accountType){
		
		assignedTo.addApplicant(this, accountType);
		
	}
	
	
	Account accessAccount(int index){
		return accounts.get(index);
	}
	
	String printAccounts(){
		
		if (accounts.isEmpty()) {
			return "No accounts found. Please apply.";
		} else {
			
			String output = "";
			
			for( int i = 0; i < accounts.size(); i++ ) {
				output += "  " + i + accounts.get(i).toString() + "\n";
			}
			
			return output;
		}
		
	}
	
	
}
