package com.HL.q3;

public class Question3
{
	public static void main(String[] args)
	{
		String myStr = "A string to reverse!";
		String reversedString = "";
		for(int i=myStr.length()-1; i>=0; i--)
		{
			reversedString += myStr.charAt(i);
		}
		System.out.println("My string is: "+myStr);
		System.out.println("My reversed string is: "+reversedString);
	}
}
