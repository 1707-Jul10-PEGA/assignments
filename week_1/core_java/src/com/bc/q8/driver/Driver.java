package com.bc.q8.driver;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	

	public static boolean isPalindrome(String str) {
		boolean ret = true;
		// checks to see if one half of the string mirrors the other
		for (int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1)){
				return false;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		ArrayList<String> arrStr = new ArrayList<String>();
		String[] strings = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer",
				"billy", "did" };
		arrStr.addAll(Arrays.asList(strings));
		
		// store palindromes in this
		ArrayList<String> strPalindromes = new ArrayList<String>();
		// we add palindromes here
		for(String s : arrStr){
			//Add if true
			if(isPalindrome(s)){
				strPalindromes.add(s);
			}
		}

	}
}
