package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sql.rowset.serial.SerialArray;

import com.revature.bankingapp.entities.account.CheckingAccount;
import com.revature.bankingapp.entities.account.SavingsAccount;
import com.revature.bankingapp.entities.person.Administrator;
import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.entities.person.Employee;
import com.revature.bankingapp.utils.Serializer;

public class AdministratorDashboard {

	Serializer serializer = new Serializer<>();
	Scanner scanner = new Scanner(System.in);
	ArrayList<Customer> allCustomers;
	ArrayList<Employee> allEmployees;
	ArrayList<SavingsAccount> allSavingAccounts;
	ArrayList<CheckingAccount> allCheckingAccounts;
	
	public int dashboard(Administrator administrator) throws FileNotFoundException, ClassNotFoundException, IOException {
		String type = "";
		loadAdministratorInfo();

		while (!type.equals("5")) {

			System.out.println("\nWelcome to your Dashboard.\nHere you can manage your see customer information");
			System.out.println("What would you like to do?\n1)View Applications\n2)View Account Balances");
			System.out.println("3)Edit an account");
			System.out.println("4)Assign an a customer to an employee");

			type = scanner.nextLine();

			switch (type) {
			case "1":
				viewApplications();
				break;
			case "2":
				viewAccounts();
				break;
			case "3":
				editAccounts();
				break;
			case "4":
				assignEmployee();
				break;
			case "5":
				saveChangesAndExit();
				return -1;
			default:
				break;
			}
		}

		return 1;
	}

	private void loadAdministratorInfo() throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		allCustomers = serializer.getPersonDatabase("customer");
		allEmployees = serializer.getPersonDatabase("employees");
		allSavingAccounts = serializer.getAllSavingsAccounts();
		allCheckingAccounts = serializer.getAllCheckingAccounts();
		
	}

	private void assignEmployee() {
		// TODO Auto-generated method stub
		
	}

	private void editAccounts() {
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

	}

}
