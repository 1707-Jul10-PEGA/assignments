package com.rb.accounts;

public class Savings extends Account {
	
	/**
     * 
     */
    private static final long serialVersionUID = -8881889190903230407L;

    public Savings(){
		setType(2);
		setInterestRate(0.05);
	}
	
}
