package com.md.q5;

import java.util.Scanner;

/*
 * Write a substring method that accepts a string and an integer index 
 * and returns the substring contained between 0 and index-1 (inclusive). 
 * DO NOT use any of the existing substring methods in the String,
 * StringBuilder or StringBuffer APIs
 */
public class Subsrting {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word and an index to find a substring: ");
		
		System.out.print("Word: ");
		String word = sc.nextLine();
		
		System.out.print("Index:");
		int index = sc.nextInt();
		
		System.out.println("Substring index " + index + " is: " + substringOf(word, index));
				
	}
	
	public static String substringOf(String str, int index) {
		//String builder is more efficient than just concatenating using + operator
		StringBuilder strB = new StringBuilder();
		
		if(index >= str.length()) {
		return "Index is longer than the word length. Please try a longer word or smaller index.";	
		}
		
		for(int i = 0; i <= index; i++) {
			strB.append(str.charAt(i));
		}
		
		return strB.toString();
	}
	
}
