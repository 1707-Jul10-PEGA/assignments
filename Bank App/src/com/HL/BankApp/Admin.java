package com.HL.BankApp;

import java.util.Scanner;
import com.HL.BankApp.Driver;

public class Admin extends User {
	String accountType = "admin";
	String x;

	public Admin(String name) {

		this.name = name;
	}

	public void menu() {
		while (!"stop".equals(x)) {
			System.out.println("1. Display all account information.");
			System.out.println("2. Approve an application.");
			System.out.println("3. Deny an application.");
			System.out.println("4. Delete an user.");
			System.out.println("5. Sign out.\n");
			User.scan = new Scanner(System.in);
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
				this.deleteAccounts();
				break;
			}
			case ("5"): {
				this.logout();
				x = "stop";
				break;
			}
			default: {
				System.out.println("Invalid input!");
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

	private void deleteAccounts() {
		System.out.println("Enter user's name to delete:");
		User.scan = new Scanner(System.in);
		String name = User.scan.nextLine();
		for (int i = 0; i < Driver.numOfUser; i++) {
			if (Driver.nameList[i].equals(name)) {
				Driver.nameList[i] = "null";
				Driver.balanceList[i] = "null";
				Driver.requests[i] = "null";
				System.out.println(name + "'s account is deleted!");
			}
		}
	}

}
