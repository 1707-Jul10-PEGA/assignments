package com.dv.bankingapp;

public class Driver {

	public static void main(String[] args) {
		int auth = 0;
		Login login = new Login();		// create the login interface

		auth = login.prompt();
		
		if(auth > 0) {
			// use dashboard!
		}
		
		else {
			System.out.println("Invalid authentication.");
		}
		
		System.out.println("Successfully exited.");
	}

}
