package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.LongAdder;

import com.revature.bankingapp.dao.CustomerDao;
import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.entities.user.Employee;

public class EmployeeDashboard {

	Scanner scanner = new Scanner(System.in);	
	Employee employee;
	ArrayList<Customer> myCustomerList;
	CustomerDao customerDao = new CustomerDao();
	
	public EmployeeDashboard() {
		// TODO Auto-generated constructor stub
	}
	
	public int employeeDashboard(Employee e) throws FileNotFoundException, ClassNotFoundException, IOException {
		this.employee = e;
		loadCustomerList();
		String selection = "";
		
		
		while (!selection.equals("5")) {

			System.out.println("\nWelcome to your Dashboard.\nHere you can manage your see customer information");
			System.out.println("What would you like to do?");
			System.out.println("1)View Applications");
			System.out.println("2)View Account Balances");
			System.out.println("3)Exit");

			selection = scanner.nextLine();

			switch (selection) {
			case "1":
				viewApplications();
				break;
			case "2":
				viewAccounts();
				break;
			case "3":
				saveChangesAndExit();
				return -1;
			default:
				break;
			}
		}

		return 1;
	}

	private void loadCustomerList() {
		// TODO Auto-generated method stub
				
	}

	private void saveChangesAndExit() {
		// TODO Auto-generated method stub
		
	}

	private void viewAccounts() {
		// TODO Auto-generated method stub
		
	}

	private void viewApplications() {
		// TODO Auto-generated method stub
		System.out.println("Select a bank application for review:");
		
		
	}

	
}
