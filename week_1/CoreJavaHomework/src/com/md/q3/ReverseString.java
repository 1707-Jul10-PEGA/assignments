package com.md.q3;

import java.util.Scanner;

/*
 * Reverse a string without using a temporary variable. Do not use reverse()
 * in the StringBuffer or StringBuilder API
 * */
public class ReverseString {

	public static void main(String[] args) {
		System.out.print("Please enter a string to reverse:");
		Scanner sc = new Scanner(System.in);
		System.out.println("Reversed string: " + reverse(sc.nextLine()));
		
	}
	
	
	public static String reverse(String myString) {
		
		StringBuilder strB = new StringBuilder();
		int strIndex = myString.length()-1;
		
		while(strIndex >= 0) {
			strB.append(myString.charAt(strIndex));
			strIndex--;
		}
				
		return strB.toString();
	}
	
	
}
