package com.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.interfaces.Login;
import com.interfaces.Menu;
import com.interfaces.login_implement.BasicLogin;
import com.users.User;

// Main application
public class BankingApplicationSQL {
	public static void main(String[] args) {
		Login login = new BasicLogin();
		String userName;
		String password;
		Scanner scan = new Scanner(System.in);
		User usr;
		String c_or_e;
		// Login as Customer, Employee, or Admin
		while (true) {
			do {
				System.out.print("Enter your username: ");
				scan = new Scanner(System.in);
				userName = scan.nextLine();
				System.out.print("Enter your password: ");
				password = scan.nextLine();
				usr = login.login(userName, password);
			} while (usr == null);
			boolean loopCondition = false;
			Menu systemUser = (Menu) usr;

			// Continue program until finished
			do {
				systemUser.displayMenu();
				loopCondition = systemUser.optionInput();
			} while (loopCondition);
			
			
			
			// Exit system or login as different user
			while(true){
				try{
				scan = new Scanner(System.in);
				System.out.print("\n Continue/Exit: ");
				c_or_e = scan.nextLine();
				if("Continue".equalsIgnoreCase(c_or_e)){
					break;
				}
				else if("exit".equalsIgnoreCase(c_or_e)){
					break;
				}
				else{
					System.out.println("Enter 'continue' or 'exit'");
					continue;
				}
				}catch(InputMismatchException e){
					System.out.println("Enter 'continue' or 'exit'");
				}
			}
			if("exit".equalsIgnoreCase(c_or_e))
				break;
		}
		System.out.println("\nExiting....\n Thank you for banking with BC Finances\nHave an nice day!");

	}
}
