package com.wh.banking_app;

public class Employee extends User{

    /**
     * 
     */
    private static final long serialVersionUID = 28295476L;
    
    public Employee(){}
    
    public Employee(String name, int ID){
	setName(name);
	setID(ID);
    }

    public boolean approve(Application application) {
	return application.approve();
    }

    public boolean deny(Application application) {
	return application.deny();
    }

    public double viewCustomerBalance(Customer c1) {
	return c1.viewBalance();
    }

}
