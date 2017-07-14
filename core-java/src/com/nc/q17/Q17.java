package com.nc.q17;

import java.util.Scanner;

public class Q17 {
	public static void main(String[] args) {
		
		//Get input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter principal: ");
		double principal = sc.nextDouble();
		System.out.print("Enter rate of interest: ");
		double rate = sc.nextDouble();
		System.out.print("Enter number of years: ");
		double year = sc.nextDouble();
		
		//Do math and show results
		double interest = principal * rate * year;
		System.out.print("Your interest is: " + interest);
	}
}
