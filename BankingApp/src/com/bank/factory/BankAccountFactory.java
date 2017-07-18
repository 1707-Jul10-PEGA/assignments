package com.bank.factory;

import com.bank.customer.Customer;
import com.bank.employee.Employee;

public class BankAccountFactory {
	public BankAccount createBankAccount(String type, Customer owner, Employee starter, String ID){
		Checking check = new Checking();
		switch(type.toLowerCase()){
		case "checking":
			System.out.println("Creating basic checking account:\n Owner: " + owner.getlName() +", " + owner.getfName());
			check = new Checking(ID, 100);
			System.out.println(" Account number: " + check.getID());
			System.out.println(" Starting amount: " + String.format("%.2f", check.getBalance()));
			check.setStarter(starter);
			System.out.println("Approved by: " + check.getNameOfStarter().getlName() + "," + check.getNameOfStarter().getfName());
			return check;
		case "savings":
		default:
			
		}
		return check;
	}
}
