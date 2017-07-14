package com.aq.q5.driver;

import java.util.Scanner;

public class Substring {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a String");
		String s = scan.nextLine();
		System.out.println("Enter an int");
		int idx = scan.nextInt();
		System.out.println(mySubstring(s,idx));
		
		scan.close();
	}
	
	public static String mySubstring(String s, int idx) {
		if(s.length() <idx) {
			return ("Index can't be larger than the String length");
		}
		String newS = "";
		for (int i = 0; i <= idx; i ++){
			newS += s.charAt(i);
		}
		return newS;
	}
}
