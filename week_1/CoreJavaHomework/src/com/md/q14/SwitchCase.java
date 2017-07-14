package com.md.q14;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * Write a program that demonstrates the switch case. Implement the following
 * functionalities in the cases.
 * 
 * Case 1: Find the square root of a number using the Math class method.
 * 
 * Case 2: Display today's date
 * 
 * Case 3: Split the following string and store it into an array. "I am learning
 * Core Java"
 * 
 * 
 * 
 * @author Martin Delira
 *
 */
public class SwitchCase {
	public static void main(String[] args) {

		System.out.print("Select a program from 1 to 3: ");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();

		switch (option) {
		case 1:
			System.out.print("Give a number to calculate its square root");
			squareRoot(sc.nextInt());
			break;
		case 2:
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			System.out.println("Today's date is: " + date);
			break;
		case 3:
			String originalString = "I am learning Core Java";
			System.out.println("Original String: " + originalString);
			System.out.println("Splited array: " + Arrays.toString(splitAndStore(originalString)));
			break;

		default:
			System.out.println("Please select a valid number from 1 to 3");
			break;
		}

	}
	
	public static void squareRoot(int number) {
		double sqrt = Math.sqrt(number);
		System.out.println("The square root of " + number + " is " + sqrt);
	}
	
	
	public static String[] splitAndStore(String sentence) {
		
		String[] splitedString = sentence.split(" ");
		
		return splitedString;
		
	}
	
}
