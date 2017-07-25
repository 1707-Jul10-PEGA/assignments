package com.rb.accounts;

import com.rb.users.Customer;

public class Savings extends Account {
	
	/**
     * 
     */
    private static final long serialVersionUID = -8881889190903230407L;

    public Savings(Customer owner){
        this.setOwner(owner);
		setType(2);
		setInterestRate(0.05);
	}

    public Savings(double balance, int status, int id, Customer owner) {
        super(balance, status, id, owner);
        setType(2);
        setInterestRate(0.05);
    }
	
}
