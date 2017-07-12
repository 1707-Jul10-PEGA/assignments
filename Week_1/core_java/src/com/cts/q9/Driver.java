//Carson Stephens
//07-10-2017

package com.cts.q9;

import java.util.*;

public class Driver
{
	public static void main (String[] args)
	{
		System.out.println("Q9");
		
		//Initialize the ArrayLists of numbers from [1, 100] and those that are prime
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		//Add all numbers from [1, 100] to first ArrayList
		for (int x = 1; x <= 100; x++)
		{
			numbers.add(x);
		}
		
		System.out.println("Prime Numbers from [1, 100]");
		//For all numbers from [1, 100] in ArrayList
		for (int x : numbers)
		{	
			//Initialize prime checker to true
			boolean isPrime = true;
			
			//For all numbers less than or equal to current number
			for (int y = 1; y <= x; y++)
			{
				//Check for a factor of the current number
				if (x % y == 0)
				{
					//If the factor is neither 1 nor the current number or if the current number is 1
					if ((y != 1) && (x != y) || (x == 1))
					{
						//Set prime checker to false and stop checking current number
						isPrime = false;
						y = x + 1;
					}
				}
			}
			
			//If the number passes the prime test, print it
			if (isPrime)
			{
				System.out.println(x);
			}
		}
	}
}