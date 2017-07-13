package com.revature.q5;

import java.util.Scanner;

public class Substrings {
	public static void main (String[] args){
		
		System.out.println("Hello! I'll return a substring for you. Please enter substring:");
		System.out.print(": ");

		Scanner sIn = new Scanner(System.in);
		String toChange = sIn.nextLine();
		System.out.println("Great. Now enter the index (idx-1 inclusive):");
		System.out.print(": ");
		int index = sIn.nextInt();
		
		String result = makeSubstring(toChange, index);
		System.out.println("Thanks! Substring is: " + result);
		sIn.close();
		
	}
	public static String makeSubstring(String str, int idx){
		
		String next = "";
		if(idx == 0){
			return "";
		}
		else{
			for(int x = 0; x < idx; x++){
				next += str.charAt(x);
			}
			return next;
		}
		
	}
	
}
