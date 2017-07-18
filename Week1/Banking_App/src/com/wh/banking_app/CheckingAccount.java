package com.wh.banking_app;

import java.io.Serializable;

public class CheckingAccount implements Account , Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 28295476L;
    private double balance;
    
    public CheckingAccount(){
	setBalance(0);
    }

    @Override
    public double withdraw(double amount) {
	if(viewBalance() >= amount){
	    balance -= amount;
	    return amount;
	}
	return -1;
    }

    @Override
    public boolean deposit(double amount) {
	setBalance(viewBalance() + amount);
	return true;
    }

    @Override
    public double viewBalance() {
	return balance;
    }

    @Override
    public boolean transfer(double amount, Account a) {
	if(viewBalance() > amount) {
	    a.deposit(withdraw(amount));
	    return true;
	}
	return false;
    }

    private void setBalance(double balance) {
	this.balance = balance;
    }

}
