package com.cg.bankingapp;

public class BankDriver {

	public static void main(String[] args) {
		int choice, exit = 0;
		InputOutput inout = new InputOutput();
		UserManagement usermanagement = new UserManagement();
		 

		usermanagement.populateHastable();

		do {
			choice = inout.welcomeMessage();
			switch (choice) {
			case 1:
				int i = usermanagement.login();
				if (i == -1) {
					System.out.println("Password incorrect");
				} else if(i == 0) {
					System.out.println("Username not found");
				}
				break;
			case 2:
				Customer c = usermanagement.applyForAccount();
				usermanagement.addApplicationToQueue(c);
				System.out.println("Application sent. Allow a few minutes and try to login. ");
				break;
			case 3:
				exit = 3;
				break;
			}
		} while (exit != 3);
		inout.cleanUp();
		usermanagement.writeToFile();
	}

}
