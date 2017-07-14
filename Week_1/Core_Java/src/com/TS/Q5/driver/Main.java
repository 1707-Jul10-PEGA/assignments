/*
 * Tae Song
 * Question 5
 */
package com.TS.Q5.driver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*tests mySubString*/
		System.out.println(mySubString("Hello World", 5));
	}

	/* mySubString
	 * 
	 * takes in a string and an integer as index and implements the substring without using any substring methods
	 * 
	 * returns the substring
	 */
	public static String mySubString(String str, int idx)
	{
		String newString = "";
		
		for (int i = 0; i < idx; i++)
		{
			newString += str.charAt(i);
		}
		
		return newString;
	}
}
