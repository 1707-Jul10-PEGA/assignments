package com.HL.BankApp;

import java.util.Scanner;
import com.HL.BankApp.Driver;

public class Employee extends User {
	String accountType = "employee";
	String x;

	public Employee(String name) {
		this.name = name;
	}

	public void menu() {
		while (!"stop".equals(x)) {

			System.out.println("1. Display all account information.");
			System.out.println("2. Approve an application.");
			System.out.println("3. Deny an application.");
			System.out.println("4. Sign out\n");

			Scanner scan = new Scanner(System.in);
			x = scan.nextLine();

			switch (x) {
			case ("1"): {
				this.viewAccounts();
				break;
			}
			case ("2"): {
				this.approveApplication();
				break;
			}
			case ("3"): {
				this.denyApplication();
				break;
			}
			case ("4"): {
				this.logout();
				x = "stop";
				break;
			}
			default: {
				System.out.println("Input not recognized.\nReturning to menu");
				break;
			}
			}
		}

	}

	private void denyApplication() {
		System.out.println("Enter user's name to deny:");
		User.scan = new Scanner(System.in);
		String name = User.scan.nextLine();
		for (int i = 0; i < Driver.numOfUser; i++) {
			if (Driver.nameList[i].equals(name)) {
				Driver.requests[i] = "denied";
				System.out.println(Driver.nameList[i] + "'s application is denied!");
			}
		}
	}

	private void approveApplication() {
		System.out.println("Enter user's name to approve:");
		User.scan = new Scanner(System.in);
		String name = User.scan.nextLine();
		for (int i = 0; i < Driver.numOfUser; i++) {
			if (Driver.nameList[i].equals(name)) {
				Driver.balanceList[i] = "0";
				Driver.requests[i] = "null";
				System.out.println(Driver.nameList[i] + "'s application is approved!");
			}
		}
	}

	private void viewAccounts() {
		for (int i = 0; i < Driver.typeList.length; i++) {
			String s = Driver.typeList[i];
			if ("customer".equals(s)) {
				System.out.println("User: " + Driver.nameList[i] + "; Balance: " + Driver.balanceList[i]
						+ "; Pending application: " + Driver.requests[i]);
			}
		}
	}

}
