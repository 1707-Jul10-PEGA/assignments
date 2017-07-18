package com.wh.banking_app;

public class UserFactory {
    
    public UserFactory(){};

    public static Employee createEmployee(String name, int ID) {
	if(ListManager.getUser(name) != null){
	    return null;
	}
	Employee employee = new Employee(name, ID);
	ListManager.addUser(employee);
	return employee;
    }

    public static Admin createAdmin(String name, int ID) {
	if(ListManager.getUser(name) != null){
	    return null;
	}
	Admin admin = new Admin(name, ID);
	ListManager.addUser(admin);
	return admin;
    }

    public static Customer createCustomer(String name, int ID) {
	if(ListManager.getCustomer(name) != null){
	    return null;
	}
	Customer customer = new Customer(name, ID); 
	ListManager.addCustomer(customer);
	ListManager.addUser(customer);
	return customer;
    }
}
