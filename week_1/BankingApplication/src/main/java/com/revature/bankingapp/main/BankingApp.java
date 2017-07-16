package com.revature.bankingapp.main;

import java.io.IOException;
import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) throws IOException {
		
		String selection = "";
				
		Scanner sc = new Scanner(System.in);
		
		while(!selection.equals("exit")) {
			welcomeMessage();
			selection = sc.nextLine();
					
			switch (selection) {
			case "1":
				
				
				break;

			case "2":
				CreateAccount manager = new CreateAccount();
				manager.newAccountProccess();
				break;

			default:
				break;
			}
			
			
		}
		
		System.out.println("Thank you for using MD Banking App");
	}
	
	public static void welcomeMessage() {
		System.out.println("Welcome to the MD Banking Application.\n"
				+ " If you want to login, enter \"1\","
				+ "if you want to create an account enter \"2\".\n "
				+ "Write \'exit\' to close program");
	}
	

}
