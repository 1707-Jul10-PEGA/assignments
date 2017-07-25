package com.revature.bankingapp.main;

import java.io.IOException;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.event.TreeWillExpandListener;

import com.revature.bankingapp.main.Login;



public class BankingApp {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		startBankingApp();
				
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
				int outcome = loginManager.login();
				if(outcome == 1) {
					logoutMessage();
					
				}else if(outcome == -1) {
					lockdown();
				}
				break;

			case "2":
				
				break;

			default:
				break;
			}
			
		}
		
		System.out.println("Thank you for using MD Banking App");

	}

	private static void lockdown() {
		System.err.println("System is currently on lockdown. Please wait");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void welcomeMessage() {
		System.out.println("Welcome to the MD Banking Application.\n");
		System.out.println("1) Log in");
		System.out.println("2) Create system account");
		System.out.print("Selection:  ");
	}

	private static void logoutMessage() {
		// TODO Auto-generated method stub
		System.out.println("Thank you for using MD Banking application. We hope to see you again soon!");
	}

}
