package com.MS.Q15.driver;

public class Calculator {
	/*
	 * The main method sets the variables to be used for the following functions.
	 * It also calls each of the four methods from the calculator and prints the
	 * result and operation that occurred.
	 */
	public static void main(String[] args) {
		int x = 12;
		int y = 2;
		
		Example c = new Example();
		System.out.println("Addition:");
		System.out.println(c.add(x, y));
		
		System.out.println("Subtraction:");
		System.out.println(c.sub(x, y));
	
		System.out.println("Multiplication:");
		System.out.println(c.mult(x, y));
		
		System.out.println("Division:");
		System.out.println(c.div(x, y));
		
	}
}
