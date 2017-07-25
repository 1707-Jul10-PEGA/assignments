package com.cg.bankingapp;

import java.util.Scanner;

public class InputOutput {

	// Variables
	private Scanner input;

	public InputOutput() {
		input = new Scanner(System.in);
	}

	public void cleanUp() {
		input.close();
	}

	// Start up message
	public int welcomeMessage() {
		String str = "Welcome to OneStop Bank.\n1.Login\n2.Apply for account.\n3.Exit\nSelection: ";
		int choice = getInputInt(str);
		while (choice < 1 || choice > 3) {
			System.out.println("Invalid input");
			choice = getInputInt(str);
		}
		return choice;
	}

	/*
	 * @param string which is printed to the console
	 * 
	 * @returns a string inputed by the user
	 */
	public String getInputString(String string) {

		// TODO CHECK FOR EMPTY STRING
		try {
			System.out.println(string);
			String str = input.nextLine();
			return str;
		} catch (NullPointerException e) {
			return getInputString(string);
		}
	}

	/*
	 * Uses str paramenter to print it the console returns the value entered as long
	 * as it's a double
	 */
	public Double getInputDouble(String str) {
		double temp;

		try {
			System.out.print(str);
			temp = Double.parseDouble(input.nextLine());
			if (temp > 0) {
				return temp;
			} else {
				return getInputDouble(str);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Most be of type double.");
			return getInputDouble(str);
		}

	}

	/*
	 * Uses str paramenter to print it the console returns the value entered as long
	 * as it's a int
	 */
	public int getInputInt(String str) {
		int temp;

		try {
			System.out.print(str);
			temp = Integer.parseInt(input.nextLine());
			if (temp > 0) {
				return temp;
			} else {
				return getInputInt(str);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Most be an integer");
			return getInputInt(str);
		}
	}

	/*public String[] loginConsole() {
		String login = getInputString("Username: ");
		String password = getInputString("Password: ");
		String[] info = { login, password };

		return info;
	}*/

}
