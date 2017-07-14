package com.revature.dd.q5;

import java.util.Scanner;

public class question5 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);  
		System.out.println("Enter a word: ");
		String n = scan.next();
		System.out.println("Enter a number: ");
		int x = scan.nextInt();
		System.out.println(substring(n, x));
		
		scan.close();
		
		
	}
	
	
	public static String substring(String str, int idx) {
		String n = "";
		
		for (int i = 0; i < idx; i++) {
			char x = str.charAt(i);
			n += x;
		}
		
		return n;
	}

}
