//Carson Stephens
//07-10-2017

package com.cts.q1;

public class Driver
{
	public static void main (String args[])
	{
		System.out.println("Q1");
		
		//Initialize array
		int[] intarr = {1, 0, 5, 6, 4, 2, 3, 7, 9, 8, 4};
		
		//Length of array
		int len = intarr.length;
		
		//Print unsorted array
		System.out.println("Unsorted Integer Array");
		for (int x = 0; x <= len-1; x++)
		{
			System.out.print(intarr[x] + " ");
		}
		System.out.println();
		
		//Use swapped to check if another cycle is needed
		boolean swapped = true;
		while (swapped)
		{
			//Reset swapped to false
			swapped = false;
			
			//For each pair
			for (int x = 1; x <= len-1; x++)
			{
				//Check if the first value is greater than the second value
				if (intarr[x-1] > intarr[x])
				{
					//If so, swap them and set swapped variable to true to continue looping
					int temp = intarr[x-1];
					intarr[x-1] = intarr[x];
					intarr[x] = temp;
					swapped = true;
				}
			}
		}
		
		//Print sorted array
		System.out.println("Bubble Sorted Integer Array");
		for (int x = 0; x <= len-1; x++)
		{
			System.out.print(intarr[x] + " ");
		}
		System.out.println();
	}
}