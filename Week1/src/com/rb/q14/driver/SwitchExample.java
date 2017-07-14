package com.rb.q14.driver;

import java.util.Calendar;
import java.util.Scanner;

public class SwitchExample {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input 1 for square root calculator\nInput 2 " +
				"for today's date\nInput 3 for string split demonstration");
		
		// read in an int, clear the newline character from entering information
		int choice = scan.nextInt();
		scan.nextLine();
		
		switch(choice){
		case 1:
			// read in a double, use the Math.sqrt method to find square root,
			// then output
			System.out.print("Input a number: ");
			double input = scan.nextDouble();
			double output = Math.sqrt(input);
			System.out.format("The square root of %.3f = %.3f", input, output);
			break;
		case 2:
			
			// get calendar object representing now, then get the field values for
			// month, day, year, and output the format as is appropriate
			Calendar today = Calendar.getInstance();
			System.out.println("Today is " + (today.get(Calendar.MONTH) + 1)+"/"+
					today.get(Calendar.DATE)+"/"+today.get(Calendar.YEAR));
			break;
		case 3:
			// create the string, split over spaces
			String toSplit = "I am learning Core Java";
			String[] split = toSplit.split(" ");
			
			// Print out in the same format as an ArrayList
			// ex: [1,5,3,34,9]
			System.out.print("["+split[0]);
			for(int i = 1; i<split.length; i++){
				System.out.print("," + split[i]);
			}
			System.out.println("]");
			break;
		default:
			break;
		}
		// close scanner
		scan.close();
	}
}