package com.revature.bankingapp.interfaces;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.entities.user.Customer;

public interface EmployeeInterface {

	public void viewCustomerAccount(Customer c, BankAccount a);
	
	/**
	 * Employee will decide if application is denied or approved
	 * @param a	-Account Application
	 * @return -True if application was approved, False otherwise
	 */
	public boolean assesApplication(Customer c);
	
	
	/**
	 * Adds a customer the employee customer list
	 * @param c	-Customer to be added
	 * @return	-True if customer was added successful, false otherwise
	 */
	public boolean addCustomerToAssignedList(Customer c);
	
	
	
}
