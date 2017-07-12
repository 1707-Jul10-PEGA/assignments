//Carson Stephens
//07-10-2017

package com.cts.q8;

import java.util.*;

public class Driver
{
	public static void main (String[] args)
	{
		System.out.println("Q8");
		
		//Initialize the ArrayLists
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		//Add all of the strings to the first ArrayList
		strings.add("karan");
		strings.add("madam");
		strings.add("tom");
		strings.add("civic");
		strings.add("radar");
		strings.add("sexes");
		strings.add("jimmy");
		strings.add("kayak");
		strings.add("john");
		strings.add("refer");
		strings.add("billy");
		strings.add("did");
		
		//Print the ArrayList of strings
		System.out.println("ArrayList of Strings");
		System.out.println(strings);
		
		//For each of the strings in the ArrayList
		for (int x = 0; x <= strings.size()-1; x++)
		{
			//Get the current string
			String str = strings.get(x);
			
			//Length of current string
			int len = str.length();
			
			//Midpoint of string, dividing the length + 1 by 2 (so length 3 has midpoint at 2 and length 4 has midpoint at 2
			int mid = (len + 1) / 2;
			
			//Initialize palindrome checker to true
			boolean isPalindrome = true;
			
			//For each half of the string
			for (int y = 0; y < mid; y++)
			{
				//Check if the left char is not the same as the right
				if (str.charAt(y) != str.charAt(len-1-y))
				{
					//If not, palindrome checker is false and break out of for loop for efficiency
					isPalindrome = false;
					y = mid;
				}
			}
			
			//If the string is a palindrome, add it to the ArrayList
			if (isPalindrome)
			{
				palindromes.add(str);
			}
		}
		
		//Print the ArrayList of palindromes
		System.out.println("List of Palindromes");
		System.out.println(palindromes);
	}
}