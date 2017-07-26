package com.revature.bankingapp.entities.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.interfaces.EmployeeInterface;

public class Employee extends SystemUser {
		
	private UUID employeeId;
	private int accessLevel;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UUID getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(UUID employeeId) {
		this.employeeId = employeeId;
	}


	public int getAccessLevel() {
		return accessLevel;
	}


	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}


	public Employee(UUID employeeId, int accessLevel) {
		super();
		this.employeeId = employeeId;
		this.accessLevel = accessLevel;
	}


	public Employee(String firstname, String lastname, String username, String password, String dob, String address,
			String userId) {
		super(firstname, lastname, username, password, dob, address, userId);
		// TODO Auto-generated constructor stub
	}


	public Employee(String firstname, String lastname, String username, String password, String dob, String address,
			UUID userId) {
		super(firstname, lastname, username, password, dob, address, userId);
		// TODO Auto-generated constructor stub
	}


	public Employee(String firstname, String lastname, String username, String password, String dob, String address) {
		super(firstname, lastname, username, password, dob, address);
		// TODO Auto-generated constructor stub
	}
	
	public Employee(SystemUser parent, UUID employeeId, int accessLevel) {
		super(parent.getFirstname(), parent.getLastName(), parent.getUsername(), parent.getPassword(), parent.getDob(), parent.getAddress());
		this.employeeId = employeeId;
		this.accessLevel = accessLevel;
	}

	
	
	
}
