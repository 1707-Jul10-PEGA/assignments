package com.revature.bankingapp.entities.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.interfaces.EmployeeInterface;

public class Employee extends SystemUser {
		
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [getFirstname()=" + getFirstname() + ", getLastName()=" + getLastName() + ", getUsername()="
				+ getUsername() + ", getDob()=" + getDob() + ", getAddress()=" + getAddress() + ", getUserId()="
				+ getUserId() + ", getPassword()=" + getPassword() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
