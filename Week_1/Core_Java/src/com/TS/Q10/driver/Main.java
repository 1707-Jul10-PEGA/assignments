/*
 * Tae Song
 * Question 10
 */
package com.TS.Q10.driver;

public class Main {

	public static void main(String[] args) {
		/*prints out the minimum value returned by the method ternaryExample*/
		System.out.println(ternaryExample(34, 12));
	}
	
	/*ternaryExample
	 * 
	 * takes in two integers uses the ternary operators to determine the minimum of the two integers
	 * 
	 * returns the minimum integer
	 */
	public static int ternaryExample(int x, int y)
	{
		int minimum = (x > y) ? y : x;
		return minimum;
	}
}
