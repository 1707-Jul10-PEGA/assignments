package com.MS.Q9.driver;

public class PrimeSort {

	/*
	 * The main function creates an input and output array of integers, as well
	 * as a counter showing how many primes have been found. It then loads the
	 * input array with number values from 1-100 and then runs through them and
	 * checks if they are prime. If they return true, it records the new prime
	 * number and increments the output counter. Finally, it prints the list of 
	 * found primes.
	 */
	public static void main(String[] args) {
	PrimeSort example = new PrimeSort();
	int[] input = new int[100];
	int[] output = new int[input.length];
	int outputcounter = 0;
	for(int i=0; i<100;i++)
	{
		input[i] = i+1;
	}
		
	for(int i=0; i<100;i++)
	{
		if(example.isPrime(input[i]))
		{
			output[outputcounter] = i+1;
			outputcounter++;
		}
	}
	
	System.out.println("List of primes up to 100 :");
	for(int i=0; i<outputcounter;i++)
	{
		System.out.println(output[i]);
	}

	}
	
	/*
	 * The isPrime function checks if a number is prime and returns
	 * a boolean value. If the supplied number is 2 or less, it has
	 * preset answers to choose from. If the number is greater than
	 * 2, it checks the modulus between said number an all integers
	 * less than it. If ANY of them have a 0 modulus, it trips a 
	 * flag and marks the number as non-prime. If said flag has
	 * not been tripped by the end of the loop, the number is prime
	 * and is marked as so.
	 */
	public boolean isPrime(int n)
	{
		if(n < 2)
		{
			return false;
		}
		else if(n == 2)
		{
			return true;
		}
		else if(n > 2)
		{
			int flag = 0;
			for(int i = 2; i < n; i++)
			{
				if((n%i) == 0)
				{
					//flag for discard
					flag = 1;
				}
			}
			if(flag == 1)
			{
				//not prime
				return false;
			}
			else if(flag == 0)
			{
				//prime
				return true;
			}
		}
		else
		{
			//Default, should never get here
			return false;
		}
		//Default, should never get here
		return false;
	}

}
