package com.revature.bankingapp.entities.account;

import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.entities.person.Employee;

public class BankAccoutApplication {

	private Customer applicant;
	private String dateOfApplication;
	private Employee proccessedBy;
	
	/**
	 * 1 "Pending"
	 * 2 "Denied"
	 * 3 "Approved"
	 */
	private String applicationStatus;
	
}
