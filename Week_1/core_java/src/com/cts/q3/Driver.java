//Carson Stephens
//07-10-2017

package com.cts.q3;

import java.util.Scanner;

public class Driver
{
	public static void main (String args[])
	{	
		System.out.println("Q3");
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{	
			//Take user input for string
			System.out.println("Input a string to reverse");
			String str = scanner.nextLine();

			//Length of string
			int len = str.length();
		
			//Starting at tail of string, add current char to end of string and work backwards
			for (int x = (len-1); x >= 0; --x)
			{
				str += str.charAt(x);
			}
			
			//Take a substring starting at the original length of the string to only take reversed half
			str = str.substring(len);
			
			//Print reversed string
			System.out.println("Reversed String");
			System.out.println(str);
		}
	}
}