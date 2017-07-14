package com.MS.Q10.driver;

public class Minimum {

	/*
	 * The main function sets up two integers to be compared against each other.
	 * It then prints out the inputted integers and the minimum value of the two
	 * (calculated using a ternary operator) to the console.
	 */
	public static void main(String[] args) {
		int a = 105;
		int b = 100;
		
		System.out.println("The supplied numbers are " + a + " and " + b);
		System.out.println("The minimum number is: " + ((a<b)? a:b));

	}

}
