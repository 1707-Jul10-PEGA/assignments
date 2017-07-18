package com.revature.bankingapp.main;

import java.io.IOException;

import java.util.Scanner;
import com.revature.bankingapp.main.Login;
import com.revature.bankingapp.utils.Serializer;
import com.revature.bankingapp.utils.SerializerTest;
import com.revature.bankingapp.main.CreateAccount;


public class BankingApp {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
//		Serializer serializer = new Serializer<>();
//		serializer.generatePersonAccounts();
//		serializer.loadDatabase();
//		System.out.println(serializer.getAllCheckingAccounts());
//		System.out.println(serializer.getAllSavingsAccounts());
		startBankingApp();
				
	}

	public static void welcomeMessage() {
		System.out.println("Welcome to the MD Banking Application.\n");
		System.out.println("1) Log in");
		System.out.println("2) Create system account");
		System.out.print("Selection:  ");
	}

	public static void startBankingApp() throws ClassNotFoundException, IOException {

		String selection = "";		

		while (!selection.equals("exit")) {
			welcomeMessage();
			Scanner sc = new Scanner(System.in);
			selection = sc.nextLine();

			switch (selection) {
			case "1":
				Login loginManager = new Login();
				loginManager.login();
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

}
