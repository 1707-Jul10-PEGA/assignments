//Carson Stephens
//07-11-2017

package com.cts.q14;

import java.util.Scanner;
import java.lang.Math;
import java.util.Date;

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Q14");
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{
			//Initialize input to 1
			int input = 1;
			
			//Loop until the input is 0, then the program will quit
			while(input != 0)
			{
				System.out.println("Enter 1-3 to test switch cases");
				System.out.println("Enter 0 to exit");
				System.out.println("Case 1: Find the square root of a number using the Math class method.");
				System.out.println("Case 2: Display today's date.");
				System.out.println("Case 3: Split the following string and store it in a string array.\n\t\"I am learning Core Java\"");
				
				//Take user input
				input = scanner.nextInt();
				
				//Switch case
				switch (input)
				{
					//If the input is 1
					case 1:
						//Take user input for a number
						double x = 0;
						System.out.print("Enter a number: ");
						x = scanner.nextDouble();
						
						//Print the square root of the input with Math.sqrt
						System.out.println("The square root of " + x + " = " + Math.sqrt(x));
						
						break;
					
					//If the input is 2
					case 2:
						//Use Date class to print current date
						Date date = new Date();
						System.out.println("Today's date is " + date);
						
						break;
					
					//If the input is 3
					case 3:
						//Initialize string to split
						String str = "I am learning Core Java";
						
						//Split string into array by spaces of any number
						String[] splitstr = str.split("\\s+");
						
						//Print string array
						System.out.println("Split String");
						for (String s : splitstr)
						{
							System.out.println(s);
						}
						
						break;
					
					//Default case (does nothing)
					default:
						break;
				}
			}
		}
	}
}