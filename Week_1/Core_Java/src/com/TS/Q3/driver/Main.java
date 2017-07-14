/*
 * Tae Song
 * Question 3
 */
package com.TS.Q3.driver;

public class Main {
	
	public static void main(String[] args)
	{
		Main Q3 = new Main();
		
		/*tests stringReverse*/
		Q3.stringReverse("Hello World");
	}
	
	/* stringReverse
	 * 
	 * takes in a string and reverses it without using reverse()
	 * 
	 * returns the reversed string
	 */
	public String stringReverse(String s)
	{
		int stringLength = s.length();
		//System.out.println(stringLength);
		int iterator = stringLength - 1;
		String reversedString = "";
		
		for (int i = iterator; i >= 0; i--)
		{
			reversedString += s.charAt(i);
		}
		System.out.println(reversedString);
		return reversedString;
	}
}
