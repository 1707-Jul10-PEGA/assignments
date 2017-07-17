package com.rb.accounts;

public class Checking extends Account {
	
	/**
     * 
     */
    private static final long serialVersionUID = -2196725851585305938L;

    public Checking(){
		setType(1);
		setInterestRate(0.025);
		
	}
}
