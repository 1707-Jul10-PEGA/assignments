package com.MS.Q19.driver;

import java.util.ArrayList;

public class EvenAndOdd {
	
	/*
	 * The sorter class does all of the sorting for this file. It generates
	 * placeholder integer arrays for evens, odds, and the primesorter. If
	 * it comes across an even/odd number, it adds them to the array/sum and
	 * moves on to the next. For the primesorter, it pops integers in the array
	 * starting from the back.
	 */
	public void Sorter (ArrayList<Integer> a)
	{
		ArrayList<Integer> evens = new ArrayList<Integer>();
		ArrayList<Integer> odds = new ArrayList<Integer>();
		ArrayList<Integer> noprimes = new ArrayList<Integer>();
		int evensum = 0;
		int oddsum = 0;
		
		for(int i=0; i<a.size();i++)
		{
			if(a.get(i)%2 == 0)
			{
				evens.add(a.get(i));
				evensum+=a.get(i);
			}
			else
			{
				odds.add(a.get(i));
				oddsum+=a.get(i);
			}
		}
		
		System.out.println("List of even integers: ");
		System.out.println(evens);
		System.out.println("Sum of even integers: ");
		System.out.println(evensum);
		System.out.println("List of odd integers: ");
		System.out.println(odds);
		System.out.println("Sum of odd integers: ");
		System.out.println(oddsum);
		
		for(int i=0; i<a.size();i++)
		{
			noprimes.add(a.get(i));
		}
		
		for(int i=noprimes.size()-1; i>0;i--)
		{
			if(this.isPrime(noprimes.get(i).intValue()))
			{
				a.remove(i);
			}
		}
		System.out.println("List of numbers without primes: ");
		System.out.println(a);
	}

	/*
	 * The main function simply sets up the input array and triggers
	 * the sorter.
	 */
	public static void main(String[] args) {
		EvenAndOdd example = new EvenAndOdd();
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		for(int i=1;i<11;i++)
		{
			input.add(i);
		}
		System.out.println("Input ArrayList");
		System.out.println(input.toString());
		
		example.Sorter(input);
		
		

	}
	
	/*
	 * The isPrime function is identical to the one created in Q9. It runs
	 * through all of the integers leading up to the provided integer and
	 * returns a boolean determining whether or not the provided integer
	 * is prime.
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
