/*
 * Tae Song
 * Question 15
 */
package com.TS.Q15.driver;

public class Main {

	/*
	 * Tests the class that implements all the appropriate basic arithmetic functionalities
	 */
	public static void main(String[] args) 
	{
		Calculator c = new Calculator();
		int x = 40;
		int y = 5;
		
		System.out.println("Testing addition:");
		System.out.println(c.addition(x, y));
		
		System.out.println("Testing subtraction:");
		System.out.println(c.subtraction(x, y));
		
		System.out.println("Testing division:");
		System.out.println(c.division(x, y));
		
		System.out.println("Testing multiplication:");
		System.out.println(c.multiplication(x, y));
	}

}
