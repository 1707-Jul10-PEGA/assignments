package com.as.q17;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to the simple interest calculator!");
		//a boolean value to keep track of valid data entry
		boolean enteredInvalidValue = false;
		//get the principle
		Double valuePrinciple = 0.0;
		do {
			System.out.print("Please enter the principle: ");
			//get string representation of principle
			String strPrinciple = s.nextLine();
			try {
				//convert string representation of principle into double value
				valuePrinciple = Double.valueOf(strPrinciple);
				enteredInvalidValue = false;
			} catch (NumberFormatException e) {
				//if data entered is invalid let the user know and try again
				System.out.println("Number format is incorrect.");
				enteredInvalidValue = true;
			}
		} while (enteredInvalidValue);
		
		//get the rate
		Double valueRate = 0.0;
		do {
			System.out.print("Please enter the rate: ");
			//get string representation of rate
			String strRate = s.nextLine();
			try {
				//convert string representation of rate into double value
				valueRate = Double.valueOf(strRate);
				enteredInvalidValue = false;
			} catch (NumberFormatException e) {
				//if data entered is invalid let the user know and try again
				System.out.println("Number format is incorrect.");
				enteredInvalidValue = true;
			}
		} while (enteredInvalidValue);
		
		//get the time
		Double valueTime = 0.0;
		do {
			System.out.print("Please enter the time in years: ");
			//get string representation of time
			String strTime = s.nextLine();
			try {
				//convert string representation of time into double value
				valueTime = Double.valueOf(strTime);
				enteredInvalidValue = false;
			} catch (NumberFormatException e) {
				//if data entered is invalid let the user know and try again
				System.out.println("Number format is incorrect.");
				enteredInvalidValue = true;
			}
		} while (enteredInvalidValue);
		
		Double interest = valuePrinciple*valueRate*valueTime;
		//print out the interest		
		System.out.println("The interest accrued is: " + interest);
		s.close();
	}
}
