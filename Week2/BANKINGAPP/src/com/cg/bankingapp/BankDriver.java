package com.cg.bankingapp;

public class BankDriver {

	public static void main(String[] args) {
		int choice, exit = 0;
		Log.log("Program started...", 1);
		InputOutput inout = new InputOutput();
		UserManagement usermanagement = new UserManagement();

		do {
			choice = inout.welcomeMessage();
			switch (choice) {
			case 1:
				int i = usermanagement.login();
				if (i == -1) {
					System.out.println("Password incorrect");
				} else if (i == 0) {
					System.out.println("Username not found");
				} else if (i == 3) {
					System.out.println("Something went wrong at login.");
				}
				break;
			case 2:
				usermanagement.applyForAccount();
				System.out.println("Application sent. Allow a few minutes and try to login. ");
				break;
			case 3:
				exit = 3;
				break;
			}
		} while (exit != 3);
		inout.cleanUp();
	}

}
