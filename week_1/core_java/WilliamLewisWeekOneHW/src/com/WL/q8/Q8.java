package com.WL.q8;

import java.util.ArrayList;

public class Q8 {

	public static void main(String[] args) {
		// Store a set of strings and save all palindromes in another ArrayList
		
		ArrayList<String> myWords = new ArrayList<String>();
		ArrayList<String> myPallys;
		myWords.add("karan");
		myWords.add("madam");
		myWords.add("tom");
		myWords.add("civic");
		myWords.add("radar");
		myWords.add("sexes");
		myWords.add("jimmy");
		myWords.add("kayak");
		myWords.add("john");
		myWords.add("refer");
		myWords.add("billy");
		myWords.add("did");
		
		myPallys = returnPalindromes(myWords);
		for(String x : myPallys)
		{
			System.out.println(x);
		}
		
		
		
	}
	
	public static ArrayList<String> returnPalindromes(ArrayList<String> myString)
	{
		ArrayList<String> myPalins = new ArrayList<String>();
		
		for(String str : myString)
		{
			if(isPalindrome(str))
			{
				myPalins.add(str);
			}
		}
		System.out.println(myPalins);
		return myPalins;
	}
	
	public static boolean isPalindrome(String str)
	{
		char[] myChars = str.toCharArray();
		for(int i = 0; i < str.length()/2-1; i++)
		{
			if(!(myChars[i] == myChars[(str.length() - i - 1)]));
			{
				return false;
			}
			 
		}
		return true; 
	}

}
