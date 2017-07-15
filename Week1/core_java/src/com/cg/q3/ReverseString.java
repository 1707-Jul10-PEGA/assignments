package com.cg.q3;

public class ReverseString {
	
	/*
	 * Reverse string by concating one character at a time
	 * from right to the left
	 */
	public String reverseString(String str) {

		for (int i = str.length() - 1; i >= 0; i--) {
			str = str.concat(String.valueOf(str.charAt(i)));
		}
		return str.substring(str.length() / 2);

	}
}
