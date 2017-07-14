/*
 * Tae Song
 * Question 14
 */
package com.TS.Q14.driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		switchCaseTest(1);
		switchCaseTest(2);
		switchCaseTest(3);
		switchCaseTest(50);
	}
	
	/* switchCaseTest
	 * 
	 * takes in an integer and uses it for the switch cases
	 * 
	 * outputs various information depending on the case
	 */
	public static void switchCaseTest(int x)
	{
		switch(x)
		{
		/*Finds the square root of a number using the Math Class method*/
		case 1:
			System.out.println("Case 1:");
			double number = 9.0;
			System.out.println("Value to be evaluated: " + number);
			double squaredNumber = Math.sqrt(number);
			System.out.println("Square root of value using Math Method: " + squaredNumber);
			System.out.println();
			break;
		/*Displays today's date using the imported DateFormat class*/
		case 2:
			System.out.println("Case 2:");
			//for formatting
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			System.out.println();
			break;
		/*Split the specified string and store the strings into a string array*/
		case 3:
			System.out.println("Case 3:");
			String splitThisString = "I am learning Core Java";
			int count = 0;
			int iterator = 0;
			/*determines the value for the number of elements in the string array*/
			for (int i = 0; i < splitThisString.length(); i++)
			{ 
				if(splitThisString.charAt(i) == ' ')
				{ count += 1; } 
			}
			
			String[] tokenizedStrings = new String[count+1];
			
			/*Stores the tokenized strings into the string array*/
			StringTokenizer tokenizer = new StringTokenizer(splitThisString);
			while (tokenizer.hasMoreTokens())
			{
				tokenizedStrings[iterator] = tokenizer.nextToken();
				if(iterator == count)
				{ break; }
				iterator += 1;
			}
			
			/*Prints out the string array*/
			System.out.println("Output of string array...");
			for(String s : tokenizedStrings)
			{
				System.out.println(s);
			}
			System.out.println();
			break;
		default:
			System.out.println("Default: ");
			System.out.println("No Matching cases");
		}
	}
}
