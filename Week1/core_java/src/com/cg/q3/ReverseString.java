package com.cg.q3;

public class ReverseString {
	
	/*
	 * Reverse string by concating one character at a time
	 * from right to the left
	 */
	public String reverseString(String str) {
		//Base Case
		if(str.length() == 1) {
			return str;
		}else {
			return str.substring(str.length()-1, str.length()) + reverseString(str.substring(0, str.length()-1));
		}
			

	}
}
