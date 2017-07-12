//Carson Stephens
//07-10-2017

package com.cts.q4;

import java.util.Scanner;

public class Driver
{
	public static void main (String args[])
	{
		System.out.println("Q4");
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{
			//Initialize N and the factorial result
			int N = -1;
			int fact = 1;
			
			//Error check to make sure that N is non-negative
			while (N < 0)
			{
				//Take user input for N
				System.out.println("Input a non-negative integer to find N factorial");
				N = scanner.nextInt();
				
				//If N is negative, try again
				if (N < 0)
				{
					System.out.println("Error, " + N + " is not a non-negative integer");
				}
			}
			
			System.out.println(N + " Factorial");
			
			//While N is greater than 1...
			while (N > 1)
			{
				//Multiply the current result by N and decrement N
				fact *= N;
				N -= 1;
			}
			
			//Print N factorial
			System.out.println(fact);
		}
	}
}