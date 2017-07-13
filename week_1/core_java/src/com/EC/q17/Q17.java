package com.EC.q17;

import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a number for your principal");
		double principal = scan.nextDouble();
		System.out.println("Please enter a number for your rate");
		double rate = scan.nextDouble();
		System.out.println("Please enter a number for your time");
		double time = scan.nextDouble();
		double interest = principal*rate*time;
		scan.close();
		System.out.println("Your overall interest is: " + interest);
		
		

	}

}
