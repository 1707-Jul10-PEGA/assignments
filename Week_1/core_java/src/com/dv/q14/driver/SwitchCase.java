package com.dv.q14.driver;

import java.util.*;

public class SwitchCase {

	public static void getSqrt() {
		double i = 0;
		Scanner read = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		i = read.nextDouble();
		
		System.out.println("The square root of " + i + " is " + Math.sqrt(i));
		read.close();
	
	}
	
	public static void getDate() {
		Date today = new Date();
		System.out.println("Today's date is " + today);
	}
	
	public static void splitString() {
		String str = "I am learning Core Java";
		String[] strArray = new String[5];
		int i = 0;
		
		for(String s : str.split(" ")) {
			strArray[i] = s;
			i++;
		}
		
		for(String s : strArray) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		int i = 0;
		Scanner read = new Scanner(System.in);

		System.out.println("Enter a case number from 1 - 3: ");
		i = read.nextInt();
		
		switch(i) {
		case 1:
			getSqrt();
			break;
		case 2:
			getDate();
			break;
		case 3:
			splitString();
			break;
		default:
			System.out.println("Error: No case for number " + i);
		}
		
		read.close();
	}

}
