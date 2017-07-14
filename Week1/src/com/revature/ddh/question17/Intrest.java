package com.revature.ddh.question17;

import java.util.Scanner;

public class Intrest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Principal rate: ");
		double princ = scan.nextDouble();
		System.out.println("Enter your rate of interest: ");
		double rate = scan.nextDouble();
		System.out.println("Enter how many years: ");
		int years = scan.nextInt();
		
		scan.close();
		
		double principal = princ * rate * years;
		System.out.println(principal);
	}
}
