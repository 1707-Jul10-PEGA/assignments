package com.as.q3;

public class Driver {

	public static void main(String[] args){
		//original string
		String str = "reverse";
		//reverse string
		String reverseStr = reverseString(str);
		//prints out reverse string and original string
		System.out.println(reverseStr + " is the reverse of " + str);
	}
	
	/*
	 * This takes a string and returns a string that is the reverse of the parameter
	 */
	private static String reverseString(String s) {
		//recursively breaks down the string s and puts it back together in reverse order
		if (s.length() > 1){
			String reverseStr = reverseString(s.substring(1, s.length())); 
			return reverseStr + s.charAt(0);
		} else {
			return s;
		}
	}
}
