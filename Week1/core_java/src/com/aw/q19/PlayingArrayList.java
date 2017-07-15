package com.aw.q19;

import java.util.ArrayList;

public class PlayingArrayList 
{
	public static void main(String[]args)
	{
		ArrayList<Integer>numbers = new ArrayList<Integer> ();
		int evenTotal = 0;
		int oddTotal = 0;
		for (int x = 1; x <= 10; x++) 
		{ 
			numbers.add(x);
		}
		System.out.println(numbers);
		for(int currentNumber: numbers)
		{
			if(currentNumber % 2 == 0)
			{
				evenTotal = evenTotal + currentNumber;
			}
		}
		System.out.println(evenTotal);
		for(int currentNumber: numbers)
		{
			if(currentNumber % 2 == 1)
			{
				oddTotal = oddTotal + currentNumber;
			}
		}
		System.out.println(oddTotal);
		numbers.remove(1);
		numbers.remove(2);
		numbers.remove(4);
		numbers.remove(6);
		
	/*	for (int x : numbers)
		{	
		boolean prime = true;
		for (int y = 1; y <= x; y++) //This will divide x by an increasing amount of numbers
			{
			if (x % y == 0 && (y != 1) && (x != y)) //if the number has no remainder, that implies numbers can divide in easily
				{
					prime = false;
				}
			}
		if (prime)
		{
			numbers.remove(x-1);
		}
	} */

		System.out.println(numbers);
	}
}