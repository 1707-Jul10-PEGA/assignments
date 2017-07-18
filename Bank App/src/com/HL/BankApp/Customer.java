package com.HL.BankApp;

import java.util.Scanner;
import com.HL.BankApp.Driver;

public class Customer extends User {
	String accountType = "customer";
	Double balance;

	String x;

	public Customer(String name, String amount) {

		this.name = name;

		if (!amount.equals("null")) {
			this.balance = Double.parseDouble(amount);
		} else {
			this.balance = (double) 0;
		}

	}

	@Override
	public void menu() {
		while (!"end".equals(x)) {

			Driver.log.info("1. Display my account information.");
			Driver.log.info("2. Deposit to my account.");
			Driver.log.info("3. Withdraw from my account.");
			Driver.log.info("4. Apply for a new account.");
			Driver.log.info("5. Sign out.\n");

			Scanner scan = new Scanner(System.in);
			x = scan.nextLine();

			switch (x) {
			case ("1"): {
				this.viewBalance();
				break;
			}
			case ("2"): {
				this.deposit();
				break;
			}

			case ("3"): {
				this.withdraw();
				break;
			}
			case ("4"): {
				this.create();
				break;
			}
			case ("5"): {
				this.logout();
				x = "end";
				break;
			}
			default: {
				Driver.log.error("Input not recognized.\nReturning to menu");
				break;
			}
			}
		}

	}

	private void create() {
		Driver.log.info("Application starts. \nEnter 'apply' to submit for approval.");
		User.scan = new Scanner(System.in);
		String input = User.scan.nextLine();
		if ("apply".equals(input.toLowerCase())) {
			Driver.log.debug("Your application has been submitted.");
			Driver.requests[Driver.userid] = input.toLowerCase();
		} else {
			Driver.log.error("Invalid Input");
		}

	}

	private void withdraw() {
		Driver.log.info("Enter the amount you want to withdraw:");
		User.scan = new Scanner(System.in);
		double withdraw = User.scan.nextDouble();

		if (withdraw > 0 && withdraw < Double.parseDouble(Driver.balanceList[Driver.userid])) {
			Driver.log.debug(withdraw + " is withdrawn from " + Driver.nameList[Driver.userid] + "'s account");
			Double newval = Double.parseDouble(Driver.balanceList[Driver.userid]) - withdraw;
			Driver.balanceList[Driver.userid] = Double.toString(newval);
			this.balance = newval;
		} else if (withdraw > 0 && withdraw > Double.parseDouble(Driver.balanceList[Driver.userid])) {
			Driver.log.error("Invalid amount.");
		} else {
			Driver.log.error("Invalid amount.");
		}
	}

	private void deposit() {
		Driver.log.info("Enter the amount you want to deposit:");
		User.scan = new Scanner(System.in);
		double deposit = User.scan.nextDouble();
		if (deposit > 0 && !"null".equals(Driver.balanceList[Driver.userid])) {
			Driver.log.debug(deposit + " is deposit to " + Driver.nameList[Driver.userid] + "'s account");
			Double newval = Double.parseDouble(Driver.balanceList[Driver.userid]) + deposit;
			Driver.balanceList[Driver.userid] = Double.toString(newval);
			this.balance = newval;
		} else {
			Driver.log.error("Invalid amount.");
		}
	}

	private void viewBalance() {
		if ("null".equals(Driver.balanceList[Driver.userid])) {
			Driver.log.error("Account does not exist.");
		} else {
			Driver.log.debug("Your total balance is: " + this.balance);
		}

		System.out.println();

	}

	public String getaccountType() {
		return accountType;
	}

	public void setaccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getbalance() {
		return balance;
	}

	public void setbalance(Double balance) {
		this.balance = balance;
	}

}
