package com.revature.bankingapp.main;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import org.omg.CORBA.PERSIST_STORE;

import com.revature.bankingapp.dao.BankAccountDao;
import com.revature.bankingapp.dao.EmployeeDao;
import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.entities.user.Employee;
import com.revature.bankingapp.interfaces.DashboardInterface;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.math.NumberUtils;



public class CustomerDashboard implements DashboardInterface {

	Customer customer;
	Map bankAccounts;
	Scanner scanner = new Scanner(System.in);
	BankAccountDao bankdao = new BankAccountDao();
	EmployeeDao empdao = new EmployeeDao();
	List<BankAccount> accountList = new ArrayList<BankAccount>();
	Employee banker = null;

	@Override
	public boolean viewBalance() {
		System.out.println("\n\nYOUR ACCOUNTS\n");
		int index = 1;
		for (BankAccount a : accountList) {

			System.out.println();
			System.out.println("Account #" + index);
			System.out.println(a.toString());
			System.out.println();
			index++;
		}

		return true;

	}

	private void printmyBankerName() {
		if (customer.getBankerId() != null) {
			System.out.print("Your Banker: ");
			System.out.println(banker.getFirstname() + " " + banker.getLastName());
		}
	}
	
	
	@Override
	public boolean withdraw() {
		
		int index = 1;
		for (BankAccount a : accountList) {

			System.out.println();
			System.out.println("Account #" + index);
			System.out.println("ID: " + a.getAccountId());
			System.out.println("Balance: " + a.getBalance());
			index++;
		}

		System.out.print("Select an account number or type 'exit' to exit process: ");
		
		
		String option = scanner.nextLine();
		if (option.compareToIgnoreCase("exit") == 0) {return false;}
		
		while (!StringUtils.isNumeric(option)) {
			System.out.println("Invalid selection. Please try again or type 'exit' to exit this process.\n");
			System.out.print("Select an account number: ");
			option = scanner.nextLine();
			if (option.compareToIgnoreCase("exit") == 0) {return false;}
		}

		index = Integer.parseInt(option);
		
		while(index > accountList.size()) {
			System.out.println("Invalid selection. Please try again or type 'exit' to exit this process.\n");
			System.out.print("Select an account number: ");
			option = scanner.nextLine();
			if (option.compareToIgnoreCase("exit") == 0) {return false;}
			
			while (!StringUtils.isNumeric(option)) {
				System.out.println("Invalid selection. Please try again or type 'exit' to exit this process.\n");
				System.out.print("Select an account number: ");
				option = scanner.nextLine();
				if (option.compareToIgnoreCase("exit") == 0) {return false;}
			}
			
			index = Integer.parseInt(option);
			if (option.compareToIgnoreCase("exit") == 0) {return false;}
						
		}
		
		BankAccount workingAccount = accountList.get(index-1);

		System.out.println("\nSELECTED ACCOUNT: #" + index);
		System.out.println(workingAccount + "\n");
		
		
		if(workingAccount.getStatus() != 1) {
			System.err.println("\nYou cant withdraw in this account at the moment. Please call your banker for more information\n");
			return false;
		}		
		
		System.out.print("Ammount to deposit: ");
		String ammount = scanner.nextLine();
		if (ammount.compareToIgnoreCase("exit") == 0) {return false;}
		
		while (!StringUtils.isNumeric(ammount) || Double.parseDouble(ammount) < 0 ) {
			System.out.println("Invalid ammount. Please try again or type 'exit' to exit process.\n");
			System.out.print("Ammount to deposit: ");
			ammount = scanner.nextLine();
			if (ammount.compareToIgnoreCase("exit") == 0) {return false;}
		}
		
		System.out.println();
		boolean update = workingAccount.withdraw(Double.parseDouble(ammount));
		System.out.println("\n");
		if(update) {
			bankdao.updateAccountBalance(workingAccount);	
		}
		
		loadUserAccounts();
		bankdao.logTransaction(workingAccount.getAccountId(), (Double.parseDouble(ammount) * -1 ));
		
		return true;
		
	}

	@Override
	public boolean deposit() {
		
		int index = 1;
		for (BankAccount a : accountList) {

			System.out.println();
			System.out.println("Account #" + index);
			System.out.println("ID: " + a.getAccountId());
			System.out.println("Balance: " + a.getBalance());
			index++;
		}

		System.out.print("Select an account number or type 'exit' to exit process: ");

		String option = scanner.nextLine();
		if (option.compareToIgnoreCase("exit") == 0) {return false;}
		
		while (!StringUtils.isNumeric(option)) {
			System.out.println("Invalid selection. Please try again or type 'exit' to exit this process.\n");
			System.out.print("Select an account number: ");
			option = scanner.nextLine();
			if (option.compareToIgnoreCase("exit") == 0) {return false;}
		}

		index = Integer.parseInt(option);
		
		while(index > accountList.size()) {
			System.out.println("Invalid selection. Please try again or type 'exit' to exit this process.\n");
			System.out.print("Select an account number: ");
			option = scanner.nextLine();
			if (option.compareToIgnoreCase("exit") == 0) {return false;}
			
			while (!StringUtils.isNumeric(option)) {
				System.out.println("Invalid selection. Please try again or type 'exit' to exit this process.\n");
				System.out.print("Select an account number: ");
				option = scanner.nextLine();
				if (option.compareToIgnoreCase("exit") == 0) {return false;}
			}
			
			index = Integer.parseInt(option);
			if (option.compareToIgnoreCase("exit") == 0) {return false;}
						
		}
		
		BankAccount workingAccount = accountList.get(index-1);

		System.out.println("\nSELECTED ACCOUNT: #" + index);
		System.out.println(workingAccount + "\n");
		
		if(workingAccount.getStatus() != 1) {
			System.err.println("\nYou cant deposit in this account at the moment. Please call your banker for more information\n");
			return false;
		}		
		
		System.out.print("Ammount to deposit: ");
		String ammount = scanner.nextLine();
		if (ammount.compareToIgnoreCase("exit") == 0) {return false;}
		
		while (!StringUtils.isNumeric(ammount) || Double.parseDouble(ammount) < 0 ) {
			System.out.println("Invalid ammount. Please try again or type 'exit' to exit process.\n");
			System.out.print("Ammount to deposit: ");
			ammount = scanner.nextLine();
			if (ammount.compareToIgnoreCase("exit") == 0) {return false;}	
		}
		
		System.out.println();
		boolean update = workingAccount.deposit(Double.parseDouble(ammount));
		System.out.println("\n");
		if(update) {
			bankdao.updateAccountBalance(workingAccount);	
		}
		
		loadUserAccounts();
		bankdao.logTransaction(workingAccount.getAccountId(), Double.parseDouble(ammount));
		
		return true;

	}

	@Override
	public boolean applyForAccount() {
		System.out.println("What type of account?Write 'exit' to exit this process without applying.");
		Map accountTypes = bankdao.getAvailableTypesOfAccounts();
		
		System.out.println(accountTypes); 
		System.out.print("Selection: ");
		
		String selection  = scanner.nextLine();
		
		if(selection.compareToIgnoreCase("exit") == 0) {
			return false;
		}
		
		while (!StringUtils.isNumeric(selection) || Integer.parseInt(selection) > accountTypes.size()) {
			System.out.println("Invalid selection. Please try again.\n");
			System.out.print("Select an account type: ");
			System.out.println(accountTypes); 
			System.out.print("Selection: ");
			selection = scanner.nextLine();
			if(selection.compareToIgnoreCase("exit") == 0) {
				return false;
			}
		}
		
		String selectedTypeOfAccount = (String) accountTypes.get(Integer.parseInt(selection));
		
		BankAccount newAccount = new BankAccount(UUID.randomUUID(), customer.getCustomerId(), 2, Integer.parseInt(selection), 0, LocalDate.now().toString());
		
		bankdao.newBankAccount(newAccount, customer.getCustomerId());
				
		System.out.println("\n\nApplication has been created."
				+ " Your applycation will be reviwed by one of our associates."
				+ "Your account will activate once it becomes approved.\n\n");
		loadUserAccounts();
		System.out.println(selectedTypeOfAccount);
		
		return false;
	}

	public int customerDashboard(Customer c) throws FileNotFoundException, ClassNotFoundException, IOException {
		String selection = "";
		this.customer = c;
		loadUserAccounts();
		loadBanker();
		
		System.out.println("\nWelcome to your Dashboard.\nHere you can manage your accounts");
		
		while (!selection.equals("5")) {
			printmyBankerName();
			System.out.println("What would you like to do?");
			System.out.println("1)View Balances");
			System.out.println("2)Widhdraw Money");
			System.out.println("3)Deposit Money");
			System.out.println("4)Apply for an account");
			System.out.println("5)Exit");
			System.out.print("\nSelection:  ");
			
			selection = scanner.nextLine();

			switch (selection) {
			case "1":
				viewBalance();
				break;
			case "2":
				withdraw();
				break;
			case "3":
				deposit();
				break;
			case "4":
				applyForAccount();
				break;
			case "5":
				saveChangesAndExit();
				return 1;
			default:
				break;
			}
		}

		return 1;
	}

	private void loadBanker() {
		if(customer.getBankerId() != null) {
		banker = empdao.getEmployeeById(customer.getBankerId());
		}
	}

	private void loadUserAccounts() {
		accountList = bankdao.getAllAccountsForCustomerWithId(customer.getCustomerId());
	}

	@Override
	public boolean saveChangesAndExit() {
		
		return false;
	}

}
