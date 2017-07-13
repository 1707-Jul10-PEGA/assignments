package com.dv.q8.driver;

import java.util.*;

public class Palindrome {

	public static String reverseString(String orig) {
		String result = "";
		int origLen = orig.length();
		
		// append to the new string starting from the end of the original
		for(int i=origLen-1; i>=0; i--) {
			result += orig.charAt(i);
		}
		
		return result;
	}

	public static ArrayList<String> getPalindromes(ArrayList<String> origList) {
		ArrayList<String> palindromeList = new ArrayList<String>();
		String temp = "";
		
		for(String s : origList) {
			temp = reverseString(s);
			
			if(temp.equals(s)) {
				palindromeList.add(temp);
			} 
		}
		
		return palindromeList;
	}

	public static ArrayList<String> initOrigList() {
		ArrayList<String> origList = new ArrayList<String>();
		origList.add("karan");
		origList.add("madam");
		origList.add("tom");
		origList.add("civic");
		origList.add("radar");
		origList.add("sexes");
		origList.add("jimmy");
		origList.add("kayak");
		origList.add("john");
		origList.add("refer");
		origList.add("billy");
		origList.add("did");
		
		return origList;
	}

	public static void main(String[] args) {
	
		ArrayList<String> origList = initOrigList();
		ArrayList<String> palindromeList = getPalindromes(origList);
		
		System.out.println("Original List: " + origList);
		System.out.println("Palindromes from this list: " + palindromeList);
	}
}
