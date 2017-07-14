package com.revature.ddh.question14;

import java.util.Scanner;
import java.lang.Math;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class question14 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number between 1, 2, and 3: ");
		int letter = scan.nextInt();
		char grade = ' ';
		scan.close();
		if (letter == 1) {
			 grade = 'a';
		}
		if (letter == 2) {
			grade = 'b';
			
		}
		if (letter == 3) {
			grade = 'c';
		}
		
		 
		switch (grade) {
		case 'a':
			System.out.println("the sqrt of 4 is " + Math.sqrt(4));
			break;
		case 'b': 
			DateFormat date = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
			Date today = new Date(0);	
			System.out.println(date.format(today));
			break;
		case 'c': 	
			String str = "I am learning Core Java";
			String[] second = str.split("C");
			System.out.println(second.toString());
			break;
		}
	}
}
