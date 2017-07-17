package com.TS.banking.resources;

/*
 * Methods to for string error checks
 */
public class UserInputTest {
	/*Checks to see if the string is a number*/
	public static boolean testIsInt(String s)
	{
		if(s.isEmpty())
		{
			return false;
		}
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '.')
			{
				return true;
			}
			if(Character.isDigit(s.charAt(i)) == false)
			{
				return false;
			}
		}
		return true;
	}
	
	/*Checks to see if string has no whitespace*/
	public static boolean testNoWhitespace(String s)
	{
		if(s.isEmpty())
		{
			return false;
		}
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == ' ')
			{
				return false;
			}
		}
		return true;
	}
	
	private UserInputTest()
	{
		
	}
}
