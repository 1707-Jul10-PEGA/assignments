/*
 * Tae Song
 * Question 19
 */
package com.TS.Q19.driver;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Creates an ArrayList and inserts integers 1 through 10*/
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
		{
			numbers.add(i+1);
		}
		
		/*Display the ArrayList*/
		System.out.println("Displaying contents of ArrayList of integers...");
		System.out.println(numbers);
		
		/*Adds up all the even numbers and stores it separately, and adds up all the odd numbers and stores it*/
		int sumEven = 0;
		int sumOdd = 0;
		for(int i : numbers)
		{
			if (myIsEven(i))
			{ sumEven += i; }
			else 
			{ sumOdd += i; }
		}
		
		/*Remove the prime numbers from the ArrayList*/
		int[] numberStore = new int[numbers.size()];
		for(int i = 0; i < numberStore.length; i++)
		{
			numberStore[i] = numbers.get(i);
		}
		for(int i = 0; i < numberStore.length; i++)
		{
			if(isPrime(i))
			{ numbers.remove(Integer.valueOf(i)); }
		}
		/*prints out the sum of all evens and sum of all odds*/
		System.out.print("The sum of all the even numbers in the ArrayList is: ");
		System.out.println(sumEven);
		System.out.print("The sum of all the odd numbers in the ArrayList is: ");
		System.out.println(sumOdd);
		
		/*prints out the contents of the ArrayList after removal of prime numbers*/
		System.out.println("The contents of the ArrayList after prime numbers were removed...");
		System.out.println(numbers);
	}

	/* myIsEven
	 * 
	 * takes in an integer and checks to see if it is even
	 * 
	 * returns true if even, false if odd
	 */
	public static boolean myIsEven(int x)
	{
		if ( (x & 1) == 0)
		{ return true; }
		else
		{ return false; }
	}
	
	/* isPrime
	 * 
	 * takes in an integer and checks to see if it is prime
	 * 
	 * returns true if prime, false if not
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
