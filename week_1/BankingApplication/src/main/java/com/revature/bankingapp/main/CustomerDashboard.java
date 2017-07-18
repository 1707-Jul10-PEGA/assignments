package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import org.omg.CORBA.PERSIST_STORE;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.entities.account.CheckingAccount;
import com.revature.bankingapp.entities.account.SavingsAccount;
import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.interfaces.BankAccountInterface;
import com.revature.bankingapp.interfaces.DashboardInterface;
import com.revature.bankingapp.utils.Serializer;

public class CustomerDashboard implements DashboardInterface {

	Serializer serializer = new Serializer<>();
	Customer customer;
	SavingsAccount savingsAccount;
	CheckingAccount checkingAccount;
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public boolean viewBalance() {
		// TODO Auto-generated method stub

		if (savingsAccount != null) {
			System.out.println(savingsAccount);
			System.out.println("\n");
		}

		if (checkingAccount != null) {
			System.out.println(checkingAccount);
			System.out.println("\n");
		}
		
		return true;
		
	}

	@Override
	public boolean withdraw() {
		System.out.println("From which account?\n1)Savings\n2)Checking");
		String option  = scanner.nextLine();
		
		switch (option) {
		case "1":
			if(savingsAccount==null) {
				System.out.println("We are sorry, but you dont have a savings account;");
				return false;
			}
			System.out.println("Ammount: ");
			double ammount = scanner.nextDouble();
			scanner.nextLine();
			return savingsAccount.withdraw(ammount);
		case "2":
			if(checkingAccount==null) {
				System.out.println("We are sorry, but you dont have a checking account;");
				return false;
			}
			System.out.println("Ammount: ");
			double ammount1 = scanner.nextDouble();
			scanner.nextLine();
			return checkingAccount.withdraw(ammount1);
		default:
			break;
		}
		return false;
	}

	@Override
	public boolean deposit() {
		// TODO Auto-generated method stub
		
		System.out.println("To which account?\n1)Savings\n2)Checking");
		String option = scanner.nextLine();
		
		switch (option) {
		case "1":			
			if(savingsAccount!=null) {
				
			System.out.println("Ammount: ");
			double ammount = scanner.nextDouble();
			return savingsAccount.deposit(ammount);
			
			}
			else
				System.out.println("\nWe are sorry, you dont have a Savings Account.\n");
			break;
			
		case "2":
			if(checkingAccount!= null) {
				
				System.out.println("Ammount: ");
				double ammount = scanner.nextDouble();
				scanner.hasNextLine();
				return checkingAccount.deposit(ammount);
				
			}
			else
				System.out.println("\nWe are sorry, you dont have a Checking Account\n");
				break;

		default:
			break;
		}
		
		return false;
	}

	public boolean createAccount() {
		System.out.println("What type of account");
		System.out.println("1) Saving");
		System.out.println("2) Checking");
		String option = scanner.nextLine();

		switch (option) {
		case "1":
			createNewSavingsAccount();	
			break;
		case "2":			
			createNewCheckingAccount();
			break;
		default:
			break;
		}
		return false;

	}

	private boolean createNewCheckingAccount() {
		// TODO Auto-generated method stub
		if(checkingAccount==null) {
			checkingAccount = new CheckingAccount(customer.getUserId());
			System.out.println("Request Created! A Bank associate will review your application");
			return true;
		}
		else if (checkingAccount!=null) {
			System.out.println("We are sorry, but you already have a checking account.\n"+checkingAccount.toString());
			return false;
		}
		return false;	
	}

	private boolean createNewSavingsAccount() {
		// TODO Auto-generated method stub
				if(savingsAccount==null) {
					savingsAccount = new SavingsAccount(customer.getUserId());
					System.out.println("Request Created! A Bank associate will review your application");
					return true;
				}
				else if (savingsAccount!=null) {
					System.out.println("We are sorry, but you already have a savings account.\n"+savingsAccount.toString());
					return false;
				}
				return false;			
	}

	private void saveChangesAndExit() throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		if(savingsAccount!= null) {
		serializer.flush(savingsAccount);
		}
		if(checkingAccount!= null) {
		serializer.flush(checkingAccount);	
		}
				
		
	}

	public int customerDashboard(Customer c) throws FileNotFoundException, ClassNotFoundException, IOException {
		String type = "";
		this.customer = c;
		serializer.loadDatabase();
		loadUserAccounts();
		
		while (!type.equals("5")) {
			
						
			System.out.println("\nWelcome to your Dashboard.\nHere you can manage your accounts");
			System.out.println("What would you like to do?\n1)View Balances\n2)Widhdraw Money\n3)Deposit Money\n4)"
					+ "Apply for an account\n5)Exit");

			type = scanner.nextLine();

			switch (type) {
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
				createAccount();
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

	private void loadUserAccounts() {
		// TODO Auto-generated method stub
		
		savingsAccount = serializer.getSavingsAccount(customer.getUserId());
		checkingAccount = serializer.getCheckingAccount(customer.getUserId());
		
	}

	
	

}
