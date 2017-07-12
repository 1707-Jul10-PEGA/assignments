//Carson Stephens
//07-10-2017

package com.cts.q6;

import java.util.Scanner;

public class Driver
{
	public static void main (String args[])
	{
		System.out.println("Q6");
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{
			//Initialize input
			int i = 0;
			
			//Take user input for i
			System.out.println("Enter an integer");
			i = scanner.nextInt();
			
			System.out.print(i + " is");
			//Use bitwise AND operator between i and 1, with 0 meaning even and otherwise meaning odd
			if ((i & 1) == 0)
			{
				System.out.println(" even");
			}
			else
			{
				System.out.println(" not even");
			}
		}
	}
}