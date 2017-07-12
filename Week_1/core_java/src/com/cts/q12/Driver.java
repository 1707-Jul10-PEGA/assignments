//Carson Stephens
//07-11-2017

package com.cts.q12;

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Q12");
		
		//Array of 100 numbers
		int[] numbers = new int[100];
		
		//Fill array with numbers from [1, 100]
		for (int x = 0; x < numbers.length; x++)
		{
			numbers[x] = (x+1);
		}
		
		//Enhanced FOR loop
		for (int x: numbers)
		{
			//Check if x is an even number
			if (x % 2 == 0)
			{
				//Print it if it is
				System.out.println(x);
			}
		}
	}
}