//Carson Stephens
//07-10-2017

package com.cts.q2;

public class Driver
{
	public static void main (String args[])
	{	
		System.out.println("Q2");
		
		//Initialize array of 25 integers
		int[] fibarr = new int[25];
		
		//Set first two values of array to 0 and 1 to set up the sequence
		fibarr[0] = 0;
		fibarr[1] = 1;
		
		//Length of array
		int len = fibarr.length;
		
		//Find the sum of the two previous values and store it as the value for the current index
		for (int x = 2; x <= len-1; x++)
		{
			fibarr[x] = fibarr[x-1] + fibarr[x-2];
		}
		
		//Print list
		System.out.println("First 25 Fibonnacci Numbers");
		for (int x = 0; x <= len-1; x++)
		{
			System.out.println((x+1) + "\t" + fibarr[x]);
		}
	}
}