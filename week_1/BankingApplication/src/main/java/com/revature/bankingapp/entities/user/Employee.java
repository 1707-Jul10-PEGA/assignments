package com.revature.bankingapp.entities.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.entities.account.BankAccoutApplication;
import com.revature.bankingapp.interfaces.EmployeeInterface;

public class Employee extends SystemUser implements EmployeeInterface {
		
	private String employeeSince;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
		
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Employee(String employeeSince, ArrayList<Customer> customerList) {
		super();
		this.employeeSince = employeeSince;
		this.customerList = customerList;
	}


	public Employee(String firstname, String lastName, String username, String password, String dob, String address,
			UUID userId) {
		super(firstname, lastName, username, password, dob, address);
		this.employeeSince = LocalDateTime.now().toString();
		// TODO Auto-generated constructor stub
	}


	public Employee(String firstname, String lastName, String username, String password, String dob, String address) {
		super(firstname, lastName, username, password, dob, address);
		// TODO Auto-generated constructor stub
	}





	public String getEmployeeSince() {
		return employeeSince;
	}

	public void setEmployeeSince(String employeeSince) {
		this.employeeSince = employeeSince;
	}
	
	public ArrayList<Customer> getCustomerAssigned() {
		return customerList;
	}

	public void setCustomerAssigned(ArrayList<Customer> customerAssigned) {
		this.customerList = customerAssigned;
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
		return this.customerList.add(c);
	}

	@Override
	public String toString() {
		return super.toString() 
				+ "Employee Since: " + this.employeeSince +"\n"
				+ "Customer List: " + customerList;
	}
	

	
	
}
