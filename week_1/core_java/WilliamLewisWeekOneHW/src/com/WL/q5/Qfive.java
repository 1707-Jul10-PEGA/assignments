package com.WL.q5;

public class Qfive {

	public static void main(String[] args) {
		// Write a substring method
		
		
		String bob = subString("0123456789", 5);
		System.out.println(bob);
	}
	public static String subString(String str, int myInt)
	{
		if( myInt <= str.length()){
			
		
		char[] myString = new char[myInt];
		for(int i = 0; i < myInt; i++)
		{
			myString[i] = str.charAt(i);
		}
		String end = new String(myString);
		return end;
		}
		else
		{
			return "Invalid, index too large.";
		
	}}}
