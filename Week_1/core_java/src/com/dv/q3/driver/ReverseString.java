package com.dv.q3.driver;

import java.util.Scanner;

public class ReverseString {
	
	public static void reverseString(String orig) {
		String result = "";
		int origLen = orig.length();
		
		// append to the new string starting from the end of the original
		for(int i=origLen-1; i>=0; i--) {
			result += orig.charAt(i);
		}
		
		System.out.println("Your word reversed: ");
		System.out.println(result);
	}
	
	public static void getUserInput() {
		String userInput = "", result = "";
		Scanner read = new Scanner(System.in);
		
		System.out.println("Type a word to reverse: ");
		userInput = read.next();
		reverseString(userInput);
	}

	public static void main(String[] args) {
		getUserInput();
	}
}
