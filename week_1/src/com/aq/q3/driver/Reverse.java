package com.aq.q3.driver;
import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a word to be reversed");
		String passedString = scan.nextLine(); 
		String reverseString = myReverse(passedString);
		System.out.println(reverseString);
		scan.close();
	}
	
	public static String myReverse(String s) {
		if(s.length() == 1) {
			return s;
		}
		else {
			return s.charAt(s.length() - 1) + myReverse(s.substring(0,s.length() - 1));
		}
	}
}
