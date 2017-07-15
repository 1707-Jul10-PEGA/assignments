package com.aw.q17;

import java.util.Scanner;

public class Finance {
	public static void main(String[] args) {
	
	Double principal, rate, interest;
	int year;
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter principal: ");
	principal = input.nextDouble();

	System.out.println("Enter rate: ");
	rate = input.nextDouble();

	System.out.println("Enter years: ");
	year = input.nextInt();
	
	interest = principal * rate * year;
	System.out.print("Your interest is: " + interest);
}

}