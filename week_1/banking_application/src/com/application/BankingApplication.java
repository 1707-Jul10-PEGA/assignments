package com.application;

import java.util.Scanner;

import com.interfaces.Login;
import com.interfaces.Menu;
import com.interfaces.login_implement.BasicLogin;
import com.users.User;

public class BankingApplication {
	public static void main(String[] args) {
		Login login = new BasicLogin();
		String userName;
		String password;
		Scanner scan  = new Scanner(System.in);
		User usr;
		
		// Login as Customer, Employee, or Admin
		do{
			System.out.print("Enter your username: ");
			scan = new Scanner(System.in); 
			userName = scan.nextLine();
			System.out.print("Enter your password");
			password = scan.nextLine();
			usr = login.login(userName, password);
		}while(usr == null);
		scan.close();
		boolean loopCondition = false;
		Menu systemUser = (Menu)usr;
		
		
		// Continue program until finished
		do{
			systemUser.displayMenu();
			loopCondition = systemUser.optionInput();
		}while(loopCondition);
		
	}
}
