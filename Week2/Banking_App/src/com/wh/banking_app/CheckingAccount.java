package com.wh.banking_app;

import java.io.Serializable;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class CheckingAccount implements Account, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 28295476L;
    private double balance;
    private int id;
    private int userID;
    private Customer customer;
    private static int approval;
    private static Logger Log = Logger.getRootLogger();

    public CheckingAccount() {
	setBalance(0);
    }
    
    public CheckingAccount(Customer customer) {
	setBalance(0);
	setCustomer(customer);
    }

    public CheckingAccount(Customer customer, double balance, int approval) {
	setBalance(balance);
	setCustomer(customer);
	this.approval = approval;
    }

    @Override
    public double withdraw(double amount) {
	Log.info("Entering withdraw method in CheckingAccount");
	if (viewBalance() >= amount) {
	    try {
		DaoManager.getTransactionLogDao().saveLog("withdraw", getUserID(), getId(), amount);
		balance -= amount;
		DaoManager.getAccountDao().updateAccount(this);
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	    return amount;
	}
	return -1;
    }

    @Override
    public boolean deposit(double amount) {
	Log.info("Entered Deposit Method in CheckingAccount");
	try {
	    DaoManager.getTransactionLogDao().saveLog("deposit", getUserID(), getId(), amount);
	    setBalance(viewBalance() + amount);
	    DaoManager.getAccountDao().updateAccount(this);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return true;
    }

    @Override
    public double viewBalance() {
	return balance;
    }

    @Override
    public boolean transfer(double amount, Account a) {
	if (viewBalance() > amount) {
	    a.deposit(withdraw(amount));
	    return true;
	}
	return false;
    }

    public void setBalance(double balance) {
	this.balance = balance;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getUserID() {
	return userID;
    }

    public void setUserID(int userID) {
	this.userID = userID;
    }

    public boolean approve() {
	approval = 1;
	Log.info("approval is " + status());
	try {
	    DaoManager.getAccountDao().updateAccount(this);
	} catch (SQLException e) {
	    Log.error("failed to approve account!");
	    e.printStackTrace();
	    return false;
	}
	return true;
    }

    public boolean deny() {
	approval = -1;
	Log.info("approval is " + status());
	try {
	    DaoManager.getAccountDao().updateAccount(this);
	} catch (SQLException e) {
	    Log.error("failed to deny account!");
	    e.printStackTrace();
	    return false;
	}
	return false;
    }

    public String status() {
	Log.info("approval num is" + approval);
	switch (approval) {
	case 0:
	    return "PENDING";
	case 1:
	    return "APPROVED";
	case -1:
	    return "DENIED";
	default:
	    Log.warn("Application approval is not 0,1, or -1");
	}
	return null; // should be unreachable
    }
    
    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }
}
