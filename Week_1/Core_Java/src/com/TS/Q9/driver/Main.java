/*
 * Tae Song
 * Question 9
 */
package com.TS.Q9.driver;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		/*Creates an ArrayList and store numbers 1 to 100 in it. Also prints out all prime numbers to console*/
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++)
		{
			numbers.add(i+1);
			if (isPrime(i+1))
			{ System.out.print((i+1) + " "); }
		}
	}
	
	/* isPrime
	 * 
	 * takes in an integer and checks to see if it is a prime number
	 * 
	 * returns true if integer is a prime number
	 */
	public static boolean isPrime(Integer x)
	{
		int counter = 0;
		if (x == 1)
		{ return false; }
		if (x == 2)
		{ return true; }
		for (int i = 2; i < x; i++)
		{
			if (x % i == 0)
			{
				counter += 1;
			}
		}
		if (counter == 0)
		{ return true; }
		else
		{ return false; }
	}
}
