package com.rb.q3.driver;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String args[]){
		// read in string from console and put it into
		// a string builder
		System.out.print("Input string to reverse: ");
		Scanner scan = new Scanner(System.in);
		StringBuilder reverse = new StringBuilder( scan.nextLine() );
		scan.close();
		
		
		for(int i = 2; i<=reverse.length(); i++){
			/* length is one higher than the last index. The last
			character stays where it is, each time, move the
			character just before the last character in the
			original string to the end of the string.
			test - move s
			tets - move e
			ttse - move t
			tset
			*/
			reverse.append(reverse.charAt(reverse.length()-i));
			reverse.deleteCharAt(reverse.length()-(i+1));
		}
		
		System.out.println(reverse);
	}
}
