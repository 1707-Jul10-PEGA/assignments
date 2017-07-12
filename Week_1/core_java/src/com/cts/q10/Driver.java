//Carson Stephens
//07-10-2017

package com.cts.q10;

import java.util.Scanner;

public class Driver
{
	public static void main (String args[])
	{
		System.out.println("Q10");
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{
			//Initialize inputs
			float x = 0;
			float y = 0;
					
			//Take user input for x
			System.out.println("Enter the 1st number");
			x = scanner.nextFloat();
			
			//Take user input for y
			System.out.println("Enter the 2nd number");
			y = scanner.nextFloat();
			
			//Use ternary operator to find minimum by comparing x and y
			//If x and y are equal, min defaults to x
			float min = (x <= y) ? x : y;
			
			System.out.println("The minimum is " + min);
		}
	}
}
		