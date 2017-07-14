/*
 * Tae Song
 * Question 13
 */
package com.TS.Q13.driver;

public class Main {
	public static void main(String[] args) {
		String systemOut = "0";
		int f = 0;				//used to differentiate between odd and even rows
		int g = 1;				//used to insert the numbers with the correct position and value
		int rows = 4;			//numbers of rows to print
		
		/*
		 * Uses the for loop in order to print out the correct pyramid
		 */
		for(int i = 1; i < 10; i++)
		{
			if (i == 1)
			{ System.out.println(systemOut + "\n");}
			
			String append = Integer.toString(g);
			if (f == 0)
			{ systemOut = g + " " + systemOut; }
			if (f == 1)
			{ systemOut = systemOut + " " + g; }
			
			f = f + 1;
			if (f == 2)
			{
				f = 0;
				g = g + 1;
			}
			if (g == 2)
			{
				g = 0;
			}
			System.out.println(systemOut);
			System.out.println();
		}
		
	}
}