/*
 * Tae Song
 * Question 16
 */
package com.TS.Q16.driver;

public class Main {

	/*
	 * Takes in a string as a command-line argument and prints out it's length, error check implemented
	 */
	public static void main(String[] args) 
	{
		if (args.length != 0)
		{ System.out.println(args[0].length()); }
		else
		{ System.out.println("Please enter a string as a command line argument"); }
	}
}
