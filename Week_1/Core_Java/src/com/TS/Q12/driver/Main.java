/*
 * Tae Song
 * Question 12
 */
package com.TS.Q12.driver;

public class Main {
	public static void main(String[] args) {
		int[] numbers = new int[100];
		
		/*calls for initializing*/
		numbers = storeNumbers(numbers);
		
		/*uses enhanced FOR loop for printing out the numbers*/
		for (int i : numbers)
		{
			if (i % 2 == 0)
			{ System.out.println(i); }
		}
	}
	
	/*storeNumbers
	 * 
	 *takes in a list of numbers as an argument and fills it with ascending integers
	 * 
	 * returns the filled list of numbers
	 */
	public static int[] storeNumbers(int[] numberList)
	{
		for (int i = 0; i < numberList.length; i++)
		{
			numberList[i] = (i+1);
		}
		return numberList;
	}
}
