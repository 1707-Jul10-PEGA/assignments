package com.as.q14;

import java.util.Calendar;

public class Driver {
	
	public static void main(String[] args) {
		//the case number to execute
		int caseNum = 2;
		
		//the number to find the square root for
		double num = 57.0;
		//variable to store the square root of num
		double sqrtNum;
		
		//String to store
		String str = "I am learning Core Java";
		//string array to store in
		String[] strArray;
		
		//switch case to demonstrate functionality
		switch(caseNum){ 
		case 1:
			sqrtNum = Math.sqrt(num);
			System.out.println(sqrtNum);
			break;
		case 2:
			
			System.out.println();
			break;
		case 3:
			strArray = str.split(" ");
			for (String s: strArray) {
				System.out.print(s + ", ");
			}
			break;
		default:
			break;
		}
	}
}

