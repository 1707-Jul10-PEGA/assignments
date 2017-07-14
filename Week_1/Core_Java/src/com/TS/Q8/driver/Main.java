/*
 * Tae Song
 * Question 8
 */
package com.TS.Q8.driver;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*Crates an ArrayList of strings and initializes it*/
		ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<String> palindromeList = new ArrayList<String>();
		stringList.add("karan");
		stringList.add("madam");
		stringList.add("tom");
		stringList.add("civic");
		stringList.add("radar");
		stringList.add("sexes");
		stringList.add("jimmy");
		stringList.add("kayak");
		stringList.add("john");
		stringList.add("refer");
		stringList.add("billy");
		stringList.add("did");
		
		/*initializes the ArrayList of palindrome only strings using isPalindrome() to check*/
		for (String indexString : stringList)
		{
			if (isPalindrome(indexString))
			{ palindromeList.add(indexString); }
		}
		
		/*Prints the ArrayList of palindrome strings*/
		System.out.println("Printing the new ArrayList of palindromes...");
		System.out.println(palindromeList);
	}
	
	/* isPalindrome
	 * 
	 * takes in a String and checks to see if it is a palindrome
	 * 
	 * returns true if the string is a palindrome
	 */
	public static boolean isPalindrome(String s)
	{
		String testString = new StringBuilder(s).reverse().toString();
		if (s.equals(testString))
		{ return true; }
		else
		{ return false; }
	}
}
