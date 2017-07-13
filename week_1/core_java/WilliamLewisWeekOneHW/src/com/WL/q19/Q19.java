package com.WL.q19;

import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {

		//List generation
		ArrayList<Integer> myInts = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
		{
			myInts.add(i+1);
		}

		//Function calls
		System.out.println("Evens add to: " + sumByRemainder(myInts, 0));
		System.out.println("Odds add to: " + sumByRemainder(myInts, 1));
		System.out.println("Removing Primes " + seivePrimes(myInts).toString());
		
	}
	/**
	 * 
	 * @param ints ArrayList of Integer values to be summed
	 * @param remainder should be 1 to sum odd values, 0 for even values.
	 * @return Returns a summation of either even or odd valued integers of the passed ArrayList
	 */
	public static int sumByRemainder(ArrayList<Integer> ints, int remainder)
	{
		int myInt = 0;
		for(Integer i: ints)
		{
			
			if(i%2 == remainder)
			{
				myInt = myInt + i;
			}
		}
		return myInt;
	}
	/**
	 * 
	 * @param ints ArrayList of Integers one wants to remove primes from
	 * @return ArrayList of Integers, minus the primes.
	 */
	public static ArrayList<Integer> seivePrimes(ArrayList<Integer> ints)
	{
		for(int i = 0; i < ints.size(); i++)
		{
			if(isPrime(i))
			{
				ints.remove(i);
			}
		}
		
		return ints;
	}
	//Stolen from question 9 Checks if an Integer is prime. 
	private static boolean isPrime(Integer i) {
		for(int j = 2; j <= Math.sqrt(i); j ++ )
		{
			//If this int is divisible by any number up to its sqrt it is composite.
			if(((i%j) == 0))
			{
				return false;
			}
		}
		//Otherwise it is prime.
		return true;
	}

}
