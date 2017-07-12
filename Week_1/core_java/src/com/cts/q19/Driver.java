//Carson Stephens
//07-11-2017

package com.cts.q19;

import java.util.*;

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Q19");
		
		//ArrayList to store numbers and prime numbers
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		//Sum of even numbers
		int evensum = 0;
		
		//Sum of odd numbers
		int oddsum = 0;
		
		//For all numbers from [1, 10]
		for (int x = 1; x <= 10; x++)
		{
			//Add to ArrayList
			numbers.add(x);
			
			//If the number is even, add it to the sum of even numbers
			if (x % 2 == 0)
			{
				evensum += x;
			}
			
			//If the number is odd, add it to the sum of odd numbers 
			else
			{
				oddsum += x;
			}
		}
		
		//Display ArrayList
		System.out.println("Numbers from [1, 10]");
		System.out.println(numbers);
		
		//Display the sum of even numbers
		System.out.println("Even Sum");
		System.out.println(evensum);
		
		//Display the sum of odd numbers
		System.out.println("Odd Sum");
		System.out.println(oddsum);
		
		
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
			
			//If the number passes the prime test, add it to the ArrayList
			if (isPrime)
			{
				primes.add(x);
			}
		}
		
		//For all objects in the prime list (use of Object instead of int prevents confusion between removal of index at x and removal of the object x) 
		for (Object x : primes)
		{
			//Remove the number from the ArrayList if it is in the list of prime numbers
			if (numbers.contains(x))
			{
				numbers.remove(x);
			}
		}
		
		//Display non-prime numbers
		System.out.println("Non-Primes");
		System.out.println(numbers);
	}
}
