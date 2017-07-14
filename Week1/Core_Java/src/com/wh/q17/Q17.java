package com.wh.q17;

import java.util.Scanner;

/**
 * Q17. Write a program that calculates the simple interest on the principal,
 * rate of interest and number of years provided by the user. Enter principal,
 * rate and time through the console using the Scanner class.
 * 
 * Interest = Principal* Rate* Time
 * 
 * @author Wei Huang
 *
 */
public class Q17 {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	double principal = 0, rate = 0, years = 0, interest = 0;

	System.out.println("This program will calculate your simple interest.");
	System.out.println("Please enter your principal.");
	if (scan.hasNextDouble()) {
	    principal = scan.nextDouble();
	}

	System.out.println("Please enter your rate of interest.");
	if (scan.hasNextDouble()) {
	    rate = scan.nextDouble();
	}

	System.out.println("Please enter the number of years.");
	if (scan.hasNextDouble()) {
	    years = scan.nextDouble();
	}

	interest = principal * rate * years;

	System.out.println("principle: " + principal);
	System.out.println("rate of interest: " + rate);
	System.out.println("years: " + years);
	System.out.println("Your simple interest is: " + interest);
	scan.close();

    }
}
