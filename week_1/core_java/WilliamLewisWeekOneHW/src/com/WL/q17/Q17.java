package com.WL.q17;

import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter your principle: ");
		float princ = scan.nextInt(); 

		System.out.println("Please enter your interest rate, as a percentage: ");
		float rate = scan.nextInt(); 
		
		System.out.println("Please enter the number of years you will be accruing interest: ");
		float year = scan.nextInt(); 
		//convert rate to decimal for the calculation
		rate = rate/100;

		float interest = rate * princ * year;
		
		System.out.println("You will earn this much: " + interest + " totaling to " + (interest + princ));
	}

}
