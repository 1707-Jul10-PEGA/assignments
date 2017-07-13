package com.revature.q17;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello! I'll calculate interest. \n Please enter the principal amount: ");
		double principal = scan.nextDouble();
		System.out.println("Principal is: " + principal + "\nPlease enter the rate: " );
		double rate = scan.nextDouble();
		System.out.println("Rate is: " + rate + "\nPlease enter the time: ");
		Double time = scan.nextDouble();
		System.out.println("Time is: " + time);
		
		scan.close();
		
		System.out.println("Amount after interest = " + principal*rate*time);
	}
}
