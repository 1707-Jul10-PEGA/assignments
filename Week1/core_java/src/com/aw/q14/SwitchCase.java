package com.aw.q14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
public class SwitchCase {
	
	private static String [] strArr;
	
	public static void main(String[] args) {
		System.out.println("Select a number between 1 through 3 to select the switch case");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		exampleSwitch(x);

	

	}
	
	public static void exampleSwitch(int caseStmt){
		switch(caseStmt){
		case 1:
			System.out.println("Square root of 100 is: " + (int) Math.sqrt(100));
			break;
		case 2:
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			System.out.println("The date is " + dtf.format(localDate));
			break;
		case 3:
			String str = "I am learning Core Java";
			strArr = str.split(" ");
			System.out.print(Arrays.toString(strArr));
		}
	}

}