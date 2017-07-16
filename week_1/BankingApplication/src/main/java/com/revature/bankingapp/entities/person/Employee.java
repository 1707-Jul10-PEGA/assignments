package com.revature.bankingapp.entities.person;

import java.util.ArrayList;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.entities.account.BankAccoutApplication;
import com.revature.bankingapp.interfaces.EmployeeInterface;

public class Employee extends Person implements EmployeeInterface {
		
	private String employeeSince;
	
	//Customer assigned to this employee	
	private ArrayList<Customer> customersAssigned = new ArrayList<Customer>();

	public String getEmployeeSince() {
		return employeeSince;
	}

	public void setEmployeeSince(String employeeSince) {
		this.employeeSince = employeeSince;
	}
	
	public ArrayList<Customer> getCustomerAssigned() {
		return customersAssigned;
	}

	public void setCustomerAssigned(ArrayList<Customer> customerAssigned) {
		this.customersAssigned = customerAssigned;
	}

	public void viewCustomerAccount(Customer c, BankAccount a) {
		// TODO Auto-generated method stub
		
	}

	public boolean assesApplication(Customer c, BankAccoutApplication a) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addCustomerToAssignedList(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ads a customer to this employee list of assigned customers.
	 * If the addition is successful, return true. False if fails.
	 * @param c	-Customer
	 * @return	True if addition was successful, false otherwise
	 */
//	public boolean addCustomerToList(Customer c) {
//		return this.customerAssigned.add(c);
//	}
	
}
