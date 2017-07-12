package com.dv.q5.driver;

import java.util.Scanner;

public class Substring {
	
	public static String getSubstring(String str, int idx) {
		String substr = "";
		
		for(int i=0; i<=idx-1; i++) {
			substr += str.charAt(i);
		}
		
		return substr;
	}
	
	public static void getUserInput() {
		String str = "", substr = "";
		int idx = 0;
		Scanner read = new Scanner(System.in);
		
		System.out.println("Enter a string and index separated by a space: ");
		str = read.next();
		idx = read.nextInt();
		
		substr = getSubstring(str, idx);
		System.out.println("Resulting substring: ");
		System.out.println(substr);
	}
	
	public static void main(String[] args) {
		getUserInput();
	}
}
