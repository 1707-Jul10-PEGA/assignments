package com.nc.q8;
import java.util.*;

public class Q8 {
	public static void main(String[] args) {
		//Create and add onto the list
		ArrayList aList = new ArrayList();
		ArrayList palindromesOnly = new ArrayList();
		aList.add("karan");
		aList.add("madam");
		aList.add("tom");
		aList.add("civic");
		aList.add("radar");
		aList.add("sexes");
		aList.add("jimmy");
		aList.add("kayak");
		aList.add("john");
		aList.add("refer");
		aList.add("billy");
		aList.add("did");
		
		//Flag to determine if the string is palindromes
		boolean flag = true;
		
		//Number of loops equals size of original list
		for(int x = 0; x < aList.size(); x++)
		{
			//Get current string
			String strHolder = aList.get(x).toString();
			//Number of loops equals to half of the length of the string round down
			//don't need to check twice or middle letter of odd length strings
			for(int y = 0; y < strHolder.length()/2; y++)
			{
				//If char at opposite ends don't match at any point then it is not a palindromes
				if(strHolder.charAt(y) != strHolder.charAt(strHolder.length()-y-1))
				{
					flag = false;
				}
			}
			//Check flag state
			if(flag == true)
			{
				//Add to palindromes list if flag stay true
				palindromesOnly.add(strHolder);
			}
			//Make sure the flag returns to original state
			flag = true;
		}
		//Display results
		System.out.println("Original List: " + aList);
		System.out.println("Palindromes List: " + palindromesOnly);
	}
}
