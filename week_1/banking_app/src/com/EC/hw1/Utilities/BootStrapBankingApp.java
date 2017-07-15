package com.EC.hw1.Utilities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import com.EC.hw1.Model.Account;
import com.EC.hw1.Model.Admin;
import com.EC.hw1.Model.BankAccount;
import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;

public class BootStrapBankingApp {

	public static void main(String[] args) {
		
		File [] user = new File("Users/").listFiles();
		File [] employee = new File("Employees/").listFiles();
		
		for(File file : user){
			Path pth = Paths.get(file.getPath());
			BankUtilities.deleteUser(pth);
		}
		
		for(File file : employee){
			Path pth = Paths.get(file.getPath());
			BankUtilities.deleteUser(pth);
		}
		
		
		
		
		
		BankAccount ba1 = new BankAccount();
		
		Customer c1 = new Customer("Elliot","Chen","ejchen","password",ba1);
		
		Account a1 = new Account("employee1@gmail.com");
		Account a2 = new Account("admin1@gmail.com");
		
		Employee e1 = new Employee("Nick","Jurzych","nicj","password",a1,new LinkedList<Customer>());
		
		Admin ad1 = new Admin("Rovy","Tech", "rtech", "password", a2);
		
		BankUtilities.writeEmployee(e1);
		BankUtilities.writeUser(e1);
		BankUtilities.writeUser(c1);
		BankUtilities.writeUser(ad1);

	}
	

}
