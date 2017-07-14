package com.md.q17;

import java.util.Scanner;

/**
 * Write a program that calculates the simple interest on the 
 * principal, rate of interest and number of years provided by 
 * the user. Enter principal, rate and time through the console
 * using the Scanner class.
 * 
 * Interest = Principal*Rate*Time
 * 
 * @author Martin Delira
 *
 */
public class InterestRate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Principal:  ");
		double principal = sc.nextDouble();
		
		System.out.print("Enter Rate:  ");
		double rate = sc.nextDouble();
		
		System.out.print("Enter Time:  ");
		double time = sc.nextDouble();
		
		System.out.println("Interest is: " + calculateInterest(principal, rate, time));
		
		
	}
	
	
	public static double calculateInterest(double p, double r, double t) {
		
		return  p*r*t;
		
	}
	
	
}
