package com.wh.banking_app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DaoManager {
    private static Logger Log = Logger.getRootLogger();
    private static UserDao ud = null;
    private static AccountDao ad = null;
    private static TransactionLogDao td = null;
    
    public static UserDao getUserDao(){
	Log.info("fetching UserDao");
	if(ud == null){
	    try {
		Log.info("creating new UserDao");
		ud = new UserDao();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	    return ud;
	}
	else return ud;
    }
    
    public static AccountDao getAccountDao(){
	Log.info("fetching AccountDao");
	if(ad == null){
	    try {
		Log.info("creating new AccountDao");
		ad = new AccountDao();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	    return ad;
	}
	else return ad;
    }
    
    public static TransactionLogDao getTransactionLogDao() {
	Log.info("fetching TransactionLogDao");
	if(td == null) {
	    try {
		Log.info("Creating new TransactiongLogDao");
		td = new TransactionLogDao();
	    }catch (SQLException e) {
		e.printStackTrace();
	    }
	    return td;
	}
	else return td;
    }
}
