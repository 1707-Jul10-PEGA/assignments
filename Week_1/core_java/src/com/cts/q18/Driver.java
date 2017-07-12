//Carson Stephens
//07-11-2017

package com.cts.q18;

import java.util.Scanner;

//Abstract superclass
abstract class A
{
	public abstract boolean upper_check(String str);
	public abstract String lower_to_upper(String str);
	public abstract int string_to_int_plus_10(String str);
}

//Concrete subclass
class B extends A
{
	//Checks if string has an uppercase character
	public boolean upper_check(String str) {
		System.out.println("Checking if \"" + str + "\" contains an uppercase character");
		
		//For each character in the string
		for (int x = 0; x < str.length(); x++)
		{
			//Check if it's uppercase
			if (Character.isUpperCase(str.charAt(x)))
			{
				//If so, return true
				return true;
			}
		}
		//If there isn't an uppercase character, return false
		return false;
	}
	
	public String lower_to_upper(String str) {
		System.out.println("Converting \"" + str + "\" to uppercase");
		
		//Convert string to uppercase and return result
		String result = str.toUpperCase();
		return result;
	}

	public int string_to_int_plus_10(String str) {
		System.out.println("Converting \"" + str + "\" to an int + 10");
		
		//Try to parse string to integer and add 10, returning result
		try
		{
			int result = Integer.parseInt(str) + 10;
			return result;
		}
		//If string cannot be converted to int, catch exception and return 0
		catch (NumberFormatException e)
		{
			return 0;
		}
	}
	
}

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Q18");
		
		//Initialize new subclass
		B b = new B();
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{
			//Take user input for string
			System.out.println("Enter a string");
			String str = scanner.nextLine();
			
			//Find if there's an uppercase character and print result
			boolean method1 = b.upper_check(str);
			System.out.println("Result: " + method1);
			
			//Convert to uppercase and print result
			String method2 = b.lower_to_upper(str);
			System.out.println("Result: \"" + method2 + "\"");
			
			//Convert to int (if possible) and add 10 and return result
			int method3 = b.string_to_int_plus_10(str);
			System.out.println("Result: " + method3);
		}
	}
}
