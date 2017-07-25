package com.revature.banking;

import java.util.Scanner;

public class BankAccountFactory {
	public BankAccount createBankAccount(String name, String type, double amount, double savingInterest,int ACCID, int CID) {
		BankAccount ba = null;
		switch(type) {
			case "saving":
				ba = new SavingAccount(name,amount,type, savingInterest,ACCID,CID);
				Main.bankAcc.add(ba);
				break;
			case "checking":
				ba = new CheckingAccount(name,amount,type,ACCID,CID);
				Main.bankAcc.add(ba);
			
		}
		return ba;
	}
	
	public BankAccount createBankAccountWithConsoleInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("what is the type of the account: [1]saving, [2]checking");
		String type = input.nextLine();
		System.out.println("what is the name of account?");
		String name = input.nextLine();
		System.out.println("Amount: ");
		double amount = Double.parseDouble(input.nextLine());
		System.out.println("Account ID: ");
		int acc = Integer.parseInt(input.nextLine());
		System.out.println("Customer ID: ");
		int CID = Integer.parseInt(input.nextLine());
		BankAccount ba = null;
		ba = new CheckingAccount(name,amount,type,acc,CID);
		Main.bankAcc.add(ba);
//		switch(type) {
//			case "saving":
//				System.out.println("Interest in decimal: ");
//				double savingInterest = Double.parseDouble(input.nextLine());
//				ba = new SavingAccount(name,amount,type, savingInterest);
//				Main.bankAcc.add(ba);
//				break;
//			case "checking":
//				ba = new CheckingAccount(name,amount,type);
//				Main.bankAcc.add(ba);
//		}
		return ba;
	}
}
