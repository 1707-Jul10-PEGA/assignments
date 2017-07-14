package com.revatrue.ddh.q3;

import java.util.Scanner;

public class question3 {

	public static void main(String []args) {
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a word: ");
		String x = reader.next();
		String y = "";
		int len = x.length();
		reader.close();

		while(len > 0){
			len--;
			char c = x.charAt(len);
			y += c;
		}
		System.out.println(y);
		
	}
}
