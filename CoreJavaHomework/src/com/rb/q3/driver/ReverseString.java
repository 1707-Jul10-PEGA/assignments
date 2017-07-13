package com.rb.q3.driver;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String args[]){
		
		System.out.print("Input string to reverse: ");
		Scanner scan = new Scanner(System.in);
		StringBuilder reverse = new StringBuilder( scan.nextLine() );
		scan.close();
		
		
		for(int i = 2; i<=reverse.length(); i++){
			reverse.append(reverse.charAt(reverse.length()-i));
			reverse.deleteCharAt(reverse.length()-(i+1));
		}
		
		System.out.println(reverse);
	}
}
