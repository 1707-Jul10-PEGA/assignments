package com.revature.bankingapp.interfaces;

public interface BankAccountInterface {
	
	public double viewBalance();
	
	public boolean withdraw(double ammount);
	
	public boolean deposit(double ammount);

	
}


