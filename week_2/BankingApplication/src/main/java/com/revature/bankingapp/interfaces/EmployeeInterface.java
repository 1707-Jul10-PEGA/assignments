package com.revature.bankingapp.interfaces;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.entities.user.Customer;

public interface EmployeeInterface {

	public void loadCustomerList();
	
	public void viewCustomerAccount();
			
	public void viewAccountApplications();
	
	public boolean assesAccountApplication();
	
	public boolean modifyAccount();
	
	public void saveChangesAndExit();
	
}
