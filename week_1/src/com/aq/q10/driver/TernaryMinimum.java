package com.aq.q10.driver;

import java.util.Scanner;

public class TernaryMinimum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first number");
		int a = scan.nextInt();
		System.out.println("Enter second number");
		int b = scan.nextInt();
		
		int minVal = (a < b) ? a : b;
		System.out.println(minVal + " is the smaller of the two numbers");
		scan.close();
	}
}
