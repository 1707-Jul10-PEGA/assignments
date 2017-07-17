package com.rb.accounts;

import java.io.Serializable;
import java.text.NumberFormat;

import com.rb.driver.Bank;
import com.rb.users.Admin;
import com.rb.users.User;


import static com.rb.driver.Driver.BANK_SYSTEM;

public abstract class Account implements Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = -6083085257987681960L;

    private double interestRate;
	
	private int monthsSinceInterest;
	
	private double balance;
	
	private int type;
	
	private int accountID;
	
	public Account(){
		accountID = Bank.getNEXT_ACCOUNT_ID();
		balance = 0.0;
		monthsSinceInterest = 0;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getType() {
		return type;
	}
	
	protected void setType(int type){
		this.type = type;
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public boolean withdraw(double amount) {
		calcInterest();
		if (amount > balance) {
			System.out.println("Transaction denied: insufficient funds");
			return false;
		} else if (amount > 0) {
			balance -= amount;
			System.out.format("You withdrew %.2f, your balance is now %.2f.%n",
					amount, balance);
			return true;
		} else{
			System.out.println("Transaction denied: invalid amount");
			return false;
		}
	}
	
	public boolean deposit(double amount){
		calcInterest();
		if (amount > 0) {
			balance += amount;
			System.out.format("You deposited %.2f, your balance is now %.2f.%n",
					amount, balance);
			return true;
		} else {
			System.out.println("Transaction denied: invalid amount");
			return false;
		}
	}
	
	public void calcInterest(){
		double interest = balance * interestRate * monthsSinceInterest;
		balance += interest;
	}
	
	public String toString() {
		
		String output = "Account type: ";
		NumberFormat form = NumberFormat.getCurrencyInstance();
		
		if (type == 2) {
			output += "Savings   ";
		} else if(type == 1) {
			output += "Checking  ";
		} else {
			// TODO logging
			return "I'm sorry, an error occurred. Account improperly created";
		}
		
		output += "Account ID: " + accountID + "  Balance: " + form.format(balance);
		
		return output;
		
	}

    public void changeBalance(Admin admin, double amount) {
        // TODO Auto-generated method stub
        
        String adminName = admin.getName();
        
        User adminCheck = BANK_SYSTEM.theBank.getUserFromMap(adminName);
        
        if(adminCheck.getAccess() == 2){
            balance += amount;
        }
        
    }
}