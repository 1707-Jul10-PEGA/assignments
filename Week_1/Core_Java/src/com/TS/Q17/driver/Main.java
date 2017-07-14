/*
 * Tae Song
 * Question 17
 */
package com.TS.Q17.driver;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*Asks for an input for the value of principal*/
		System.out.println("Please enter the amount of principal");
		double principal = scan.nextDouble();
		
		/*Asks for an input for the value of rate*/
		System.out.println("Please enter your interest rate");
		double rate = scan.nextDouble();
	
		/*Asks for an input for the value of years*/
		System.out.println("Please enter the amount of years");
		double years = scan.nextDouble();
		
		/*prints out the interest using the method interest*/
		System.out.println("Your interest is: " + interest(principal, rate, years));
	}
	
	/* interest
	 * 
	 * takes in 3 double-variables and multiplies them
	 * 
	 * returns the interest
	 */
	public static double interest(double x, double y, double z)
	{
		return x * y * z;
	}
}
