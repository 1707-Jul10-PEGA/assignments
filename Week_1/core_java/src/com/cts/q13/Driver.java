//Carson Stephens
//07-11-2017

package com.cts.q13;

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Q13");
		
		//Initialize number of lines to print to 4
		int lines = 4;
		
		//First printed number starts at 0
		int i = 0;
		
		//Print the yth line, from 1 to 4
		for (int y = 1; y <= lines; y++)
		{
			//Print the xth value, from 1 to y
			for (int x = 1; x <= y; x++)
			{
				//Print by alternating 0 and 1 with mod 2 and incrementing
				System.out.print(i % 2 + " ");
				i++;
			}
			//Skip to next line at the end of the current line
			System.out.println();
		}
	}
}