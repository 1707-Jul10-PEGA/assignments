package com.as.q5;

public class Driver {

	public static void main(String[] args) {
		//The string to be partitioned
		String str = "string";
		//the ending index
		int endIndex = str.length() / 2;
		//the new substring
		String subStr = subString(str, endIndex);
		//print out the substring and original string
		System.out.println(subStr + " is a substring of " + str);
	}
	
	/*
	 * Builds a substring by concatenating a letter from the parameter string
	 * to a new string.
	 */
	private static String subString(String s, int index){
		String sub = "";
		for(int i = 0; i < index; i++) {
			sub += s.charAt(i);
		}
		return sub;
	}
	
}
