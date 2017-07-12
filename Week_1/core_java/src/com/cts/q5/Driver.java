//Carson Stephens
//07-10-2017

package com.cts.q5;

import java.util.Scanner;

public class Driver
{
	public static void main (String args[])
	{
		System.out.println("Q5");
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{
			//Initialize str and idx
			String str = "";
			int idx = 0;
			
			//Error check to make sure that idx is positive
			while (idx <= 0)
			{
				//Take user input for str
				System.out.println("Input a string for str");
				str = scanner.nextLine();
				
				//Take user input for idx
				System.out.println("Input a positive integer for idx");
				idx = scanner.nextInt();
				
				//If idx is non-positive, try again
				if (idx <= 0)
				{
					System.out.println("Error, " + idx + " is not a positive integer");
				}
				
				//Set idx to highest possible value for str's length if it's too high
				if (idx > str.length()-1)
				{
					idx = str.length() - 1;
				}
			}
			
			//Initialize substring
			String sub = "";
			
			//Add the char at each index within [0, idx]
			for (int x = 0; x <= idx; x++)
			{
				sub += str.charAt(x);
			}
			
			//Print substring
			System.out.println("Substring of str from [0, " + idx + "]");
			System.out.println(sub);
		}
	}
}