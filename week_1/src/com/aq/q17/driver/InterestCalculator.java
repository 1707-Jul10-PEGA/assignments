package com.aq.q17.driver;

import java.util.Scanner;

public class InterestCalculator {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the principal :");
		double principal = Double.valueOf(scan.nextLine());
		
		System.out.println("Enter the interest rate");
		double rate = Double.valueOf(scan.nextLine());
		
		System.out.println("Enter the time in years");
		int years = scan.nextInt();
		
		System.out.println("Your interest is :" + String.valueOf((principal * rate * years)));
	}
}
