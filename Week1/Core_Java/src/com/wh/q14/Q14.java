package com.wh.q14;

import java.util.Scanner;
import java.util.Calendar;

public class Q14 {
	
	private static String[] strArr;
	
	private static void sqrtCase(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input a number to find the square root of it.");
		int i = scan.nextInt();
		System.out.println("The root of " + i + " is: " + Math.sqrt(i));
		scan.close();
	}
	
	private static void getDate(){
		System.out.println(Calendar.getInstance().getTime());
	}
	
	private static void splitString(){
		strArr = "I am learning Core Java".split(" ");
	}
	
	private static void switchMethod(int x ){
		switch(x){
		case 1:		sqrtCase();
					break;
		case 2: 	getDate();
					break;
		case 3:		splitString();
					break;
		default: 	System.out.println("no case found");
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 4; i++){
			switchMethod(i);
		}
		System.out.println(strArr[3]+" "+strArr[4]+" "+strArr[2]+" "+strArr[0]+" "+strArr[1]);
	}
}
