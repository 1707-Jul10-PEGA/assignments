package com.aq.q14.driver;

import java.util.Scanner;
import java.math.*;
import java.util.Arrays;
import java.util.Date;

public class SwitchCase {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1,2, or 3");
		String c = scan.nextLine();
		
		switch(c) {
		
		case "1" : 
			System.out.println(Math.sqrt(16.0));
			break;
		case "2" :
			Date date = new Date();
			System.out.println(date);
			break;
		case "3" :
			String s = "I am learning Core Java";
			String[] words = s.split(" ");
			System.out.println(Arrays.toString(words));
			break;
		}
		scan.close();
	}
}
