package com.wh.banking_app;

import java.io.Serializable;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Application implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 28295476L;
    private static int approval;
    private Customer customer;
    private static Logger Log = Logger.getRootLogger();
    
    public Application() {}
    
    public Application(Customer customer) {
	setCustomer(customer);
    }
    
    public boolean approve() {
	try {
	    DaoManager.getTransactionLogDao().saveLog("approve", getCustomer().getId(), ((CheckingAccount)getCustomer().getCheckingAccount()).getId(), 0);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	approval = 1;
	Log.info("approval is" + status());
	return true;
    }
    
    public boolean deny() {
	try {
	    DaoManager.getTransactionLogDao().saveLog("deny", getCustomer().getId(), ((CheckingAccount)getCustomer().getCheckingAccount()).getId(), 0);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	approval = -1;
	Log.info("approval is" + status());
	return false;
    }
    
    public String status() {
	Log.info("approval num is" + approval);
	switch(approval) {
	case  0:	return "PENDING";
	case  1:	return "APPROVED";
	case -1:	return "DENIED";
	default: Log.warn("Application approval is not 0,1, or -1");
	}
	return null; // should be unreachable
    }

    public Customer getCustomer() {
	return customer;
    }

    private void setCustomer(Customer customer) {
	this.customer = customer;
    }
}
