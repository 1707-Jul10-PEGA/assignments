package com.rb.accounts;

import com.rb.users.Customer;

public class Checking extends Account {
	
	/**
     * 
     */
    private static final long serialVersionUID = -2196725851585305938L;

    public Checking(Customer owner){
        this.setOwner(owner);
		setType(1);
		setInterestRate(0.025);
		
	}

    public Checking(double balance, int status, int id, Customer owner) {
        super(balance, status, id, owner);
        setType(1);
        setInterestRate(0.025);
    }
}
