package q17;

import java.util.*;

/*
 * Write a program that calculates the simple interest on the principle,
 * rate of interest and number of years provided by the user. Enter principle,
 * rate and time through the console using the Scanner Class. 
 * 
 * 	Interest = Principle * Rate * Time
 */

public class SimpleInterest {
	
	public static double CalculateSI(double principle, double rate, int time) {
		double interest = principle * rate * time;
		return interest;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Lets Calculate your Interest Rate.\n");
		System.out.println("Enter your Information Below.");
		
		System.out.print("Principle: ");
		double principle = s.nextDouble();
		System.out.println();
		System.out.print("Rate: ");
		double rate = s.nextDouble();
		System.out.println();
		System.out.print("Time: ");
		int time = s.nextInt();
		System.out.println();
		
		System.out.println("Interest = $" + (CalculateSI(principle, rate, time)) );
		
		
	}

}
