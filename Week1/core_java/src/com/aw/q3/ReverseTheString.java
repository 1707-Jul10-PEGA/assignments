package com.aw.q3;

import java.util.Scanner;

public class ReverseTheString {
	public static void main(String[]args) {
	System.out.println("Type up a string that you want to reverse and then press Enter");
	Scanner input = new Scanner(System.in);
	String theWord = input.next();
	//System.out.println(theWord);
	for (int x = theWord.length() - 1; x >= 0; x--) {
		//theWord+= theWord.charAt(x);
		//theWord = theWord.substring(x);
		System.out.print(theWord.charAt(x)); //YES. It will keep printing out characters backwards as it loops through the thing. It prints out each individual character over and over
		}
	//System.out.print(theWord.charAt(x));
	}
	
}
