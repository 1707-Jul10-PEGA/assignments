package com.revature.bankingapp.main;

import java.io.IOException;
import java.util.Scanner;
import com.revature.bankingapp.main.Login;
import com.revature.bankingapp.main.CreateAccount;


public class BankingApp {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		startBankingApp();
	}

	public static void welcomeMessage() {
		System.out.println("Welcome to the MD Banking Application.\n" + "If you want to login, enter \"1\","
				+ "if you want to create an account enter \"2\".\n" + "Write \'exit\' to close program\n\n");
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
