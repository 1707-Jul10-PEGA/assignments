package com.MS.Q8.driver;

import java.util.ArrayList;

public class PalindromeDetect {
	
	/*
	 * The Detector function simply takes a string input (in this case, an index
	 * to an array of strings), reverses it, then checks it against the original string.
	 * It returns true or false depending on whether or not the string is a palindrome.
	 */
	public boolean Detector(String ispal)
	{
		StringBuilder testcase = new StringBuilder(ispal);
		
		if(ispal.equals(testcase.reverse().toString()))
		{
			System.out.println(ispal + " was a palindrome.");
			return true;
		}
		else
		{
			System.out.println(ispal + " was NOT a palindrome");
			return false;
		}
	}
	
/*
 * The main function adds all of the supplied strings to an ArrayList. It then
 * creates a for-loop that returns a boolean value for each element of the list.
 * If the returned value is true, it adds the indexed value to the output ArrayList.
 * Finally, it prints the output ArrayList to the console.
 */
	public static void main(String[] args) {
		PalindromeDetect doer = new PalindromeDetect();
		
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("karan");
		ar.add("madam");
		ar.add("tom");
		ar.add("civic");
		ar.add("radar");
		ar.add("sexes");
		ar.add("jimmy");
		ar.add("kayak");
		ar.add("john");
		ar.add("refer");
		ar.add("billy");
		ar.add("did");
		
		
		ArrayList<String> op = new ArrayList<String>();
		boolean ret;
		for(int i=0; i<ar.size();i++)
		{
			ret = doer.Detector(ar.get(i).toString());
			if(ret)
			{
				op.add(ar.get(i).toString());
			}
		}
		
		System.out.println("\n\nList of palindromes: ");
		for(int i=0; i<op.size(); i++)
		{
			System.out.println(op.get(i).toString());
		}
		
		

	}

}
