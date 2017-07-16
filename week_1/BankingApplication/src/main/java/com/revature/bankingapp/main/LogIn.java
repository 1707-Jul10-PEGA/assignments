package com.revature.bankingapp.main;

import java.util.Scanner;

public class LogIn {

	public void logIn() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your credentials:");
		
		System.out.println("Username:");
		
		String username = sc.nextLine();
		
		System.out.println("Password:");
		
		String password = sc.nextLine();
		
		sc.close();
		
		
		
	}
	
	
	
	
}
