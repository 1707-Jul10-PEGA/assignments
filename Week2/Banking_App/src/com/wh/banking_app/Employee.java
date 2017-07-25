package com.wh.banking_app;

import java.sql.SQLException;

public class Employee extends User {

    /**
     * 
     */
    private static final long serialVersionUID = 28295476L;

    public Employee() {
    }

    public Employee(String name, int ID) {
	setName(name);
	setPassword(ID);
    }

    public boolean approve(Account acc) {
	try {
	    DaoManager.getTransactionLogDao().saveLog("approve", getId(),
		    ((CheckingAccount)acc).getId(), 0);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return acc.approve();
    }

    public boolean deny(Account acc) {
	
	try {
	    DaoManager.getTransactionLogDao().saveLog("deny", getId(),
		    ((CheckingAccount)acc).getId(), 0);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return acc.deny();
    }
    /*
     * public boolean approve(Application application) { return
     * application.approve(); }
     * 
     * public boolean deny(Application application) { return application.deny();
     * }
     */

    public double viewCustomerBalance(Customer c1) {
	return c1.viewBalance();
    }

}
