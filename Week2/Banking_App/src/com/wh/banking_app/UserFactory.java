package com.wh.banking_app;

import java.sql.SQLException;

public class UserFactory {

    public UserFactory() {
    };

    public static Employee createEmployee(String name, int ID) throws SQLException {
	/*
	 * if(ListManager.getUser(name) != null){ return null; }
	 */
	if (DaoManager.getUserDao().getUser(name, ID) != null) {
	    return null;
	}
	Employee employee = new Employee(name, ID);
	// ListManager.addUser(employee);
	if (DaoManager.getUserDao().saveUser(employee, 2) == -1) {
	    return null;
	}
	return (Employee) DaoManager.getUserDao().getUser(name, ID);
    }

    public static Admin createAdmin(String name, int ID) throws SQLException {
	/*
	 * if(ListManager.getUser(name) != null){ return null; }
	 */
	if (DaoManager.getUserDao().getUser(name, ID) != null) {
	    return null;
	}
	Admin admin = new Admin(name, ID);
	// ListManager.addUser(admin);
	if (DaoManager.getUserDao().saveUser(admin, 0) == -1) {
	    return null;
	}
	return (Admin)DaoManager.getUserDao().getUser(name, ID);
    }

    public static Customer createCustomer(String name, int ID) throws SQLException {
	/*
	 * if(ListManager.getCustomer(name) != null){ return null; }
	 */
	if (DaoManager.getUserDao().getUser(name, ID) != null) {
	    return null;
	}
	Customer customer = new Customer(name, ID);
	// ListManager.addCustomer(customer);
	// ListManager.addUser(customer);
	if (DaoManager.getUserDao().saveUser(customer, 1) == -1) {
	    return null;
	}
	
	return (Customer) DaoManager.getUserDao().getUser(name, ID);
    }
}
