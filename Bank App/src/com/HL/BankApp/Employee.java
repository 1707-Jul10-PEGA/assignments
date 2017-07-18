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
		while (!"end".equals(x)) {

			Driver.log.info("1. Display all account information.");
			Driver.log.info("2. Approve an application.");
			Driver.log.info("3. Deny an application.");
			Driver.log.info("4. Sign out\n");

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

	private void denyApplication() {
		Driver.log.info("Enter user's name to deny:");
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
		Driver.log.info("Enter user's name to approve:");
		User.scan = new Scanner(System.in);
		String name = User.scan.nextLine();
		for (int i = 0; i < Driver.numOfUser; i++) {
			if (Driver.nameList[i].equals(name)) {
				Driver.balanceList[i] = "0";
				Driver.requests[i] = "null";
				Driver.log.debug(Driver.nameList[i] + "'s application is approved!");
			}
		}
	}

	private void viewAccounts() {
		for (int i = 0; i < Driver.typeList.length; i++) {
			String s = Driver.typeList[i];
			if ("customer".equals(s)) {
				Driver.log.info("User: " + Driver.nameList[i] + "; Balance: " + Driver.balanceList[i]
						+ "; Pending application: " + Driver.requests[i]);
			}
		}
	}

}
