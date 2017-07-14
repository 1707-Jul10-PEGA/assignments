package com.jntm.q17.driver;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Calculate interest from scanner
		
		//Set scanner
		Scanner scanner = new Scanner(System.in);

		//Init variables
		double time = 0.0, principal = 0.0, rate = 0.0;

		//Get info. There's no input sanitization though.
		System.out.println("How much is the principal?");
		principal = scanner.nextDouble();
		System.out.println("What is the interest rate? (EX: 3% is .03) ");
		rate = scanner.nextDouble();
		System.out.println("How many years will it rest?");
		time = scanner.nextDouble();
		
		//Format to look nice as money.
		DecimalFormat myFormatter = new DecimalFormat("###,###.00");
		scanner.close();
		//Output
		System.out.println("Your interest will be $" + myFormatter.format(principal*rate*time)+"! How interesting!");
	}

}
