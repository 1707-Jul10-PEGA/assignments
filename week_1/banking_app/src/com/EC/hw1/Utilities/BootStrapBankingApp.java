package com.EC.hw1.Utilities;

import java.util.LinkedList;

import com.EC.hw1.Model.Account;
import com.EC.hw1.Model.BankAccount;
import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;

public class BootStrapBankingApp {

	public static void main(String[] args) {
		
		BankAccount ba1 = new BankAccount();
		Customer c1 = new Customer("Elliot","Chen","ejchen","password",ba1);
		Account a1 = new Account("employee1@gmail.com");
		Employee e1 = new Employee("Nick","Jurzych","nicj","password",a1,new LinkedList<Customer>());
		BankUtilities.writeEmployee(e1);
		BankUtilities.writeUser(e1);
		BankUtilities.writeUser(c1);

	}

}
