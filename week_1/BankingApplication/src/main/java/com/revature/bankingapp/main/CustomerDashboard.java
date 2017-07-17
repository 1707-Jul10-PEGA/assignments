package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.revature.bankingapp.entities.account.BankAccount;
import com.revature.bankingapp.entities.account.CheckingAccount;
import com.revature.bankingapp.entities.account.SavingsAccount;
import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.interfaces.BankAccountInterface;
import com.revature.bankingapp.utils.Serializer;

public class CustomerDashboard implements BankAccountInterface{

	@Override
	public double viewBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean withdraw(double ammount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(double ammount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void viewBalances(Customer c) throws FileNotFoundException, ClassNotFoundException, IOException {
						
	
		
	}
	
	public void withdrawMoney() {
		System.out.println("From which account?");
		
		
	}
	
	public void createAccount(Customer c) {
		System.out.println("What type of account");
		System.out.println("1) Checking");
		System.out.println("2) Saving");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		switch (s) {
		case "1":
			c.setChecking(createChekcingAccount(c.getUserId()));
			System.out.println("Request Created!");
		case "2":
			c.setSaving(createSavingsAccount(c.getUserId()));
			System.out.println("Request Created!");
		default:
			break;
		}
				
	}
	
	public CheckingAccount createChekcingAccount(UUID userid) {
				
		CheckingAccount checking = new CheckingAccount(UUID.randomUUID(), 0, LocalDate.now().toString(), userid);
		return checking;
	}
	
	public SavingsAccount createSavingsAccount(UUID userid) {
		
		SavingsAccount saving = new SavingsAccount(UUID.randomUUID(), 0, LocalDate.now().toString(), userid);
		return saving;
	}
		
		
	public int customerDashboard(Customer c) throws FileNotFoundException, ClassNotFoundException, IOException {
		String type = "";
		Scanner sc = new Scanner(System.in);
	
		Serializer serializer = new Serializer<>();
		//c.setSaving(serializer.getSavingAccounts(c.getUserId()));
		//c.setChecking(serializer.getCheckingAccounts(c.getUserId())); 
		
		
		while(!(type.equals("1") || type.equals("2") || type.equals("3") || type.equals("4")) ) {
			
			System.out.println("Welcome to your Dashboard.\nHere you can manage your accounts");
			System.out.println("What would you like to do?\n1)View Balances\n2)Widhdraw Money\n3)Deposit Money\n4)"
					+ "Apply for a Savings account\n5)Apply for a Checking Account\n6)Exit");
			
			type = sc.nextLine();
			
			switch (type) {
			case "1":
				//viewBalances(c);
				break;
			case "2":
				withdrawMoney();
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				//createAccount(c);
				break;
			case "6":
				return -1;
			default:
				break;
			}
		}
		
			
	
		
		return 1;
	}
	
	
	
	
	
	

}
