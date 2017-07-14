package com.md.q10;

import java.util.Scanner;

/**
 * Find the minimum of two numers using ternary operators
 * @author Martin Delira
 *
 */
public class Ternary {

	public static void main(String[] args) {
		System.out.println("Enter Two numbers to find min: ");
		Scanner sc = new Scanner(System.in);
		System.out.print("Number1 :");
		int num1 = sc.nextInt();
		
		System.out.print("Number2 :");
		int num2 = sc.nextInt();
		System.out.println("Min of " + num1 + " and " + num2 + " is: " + min(num1, num2));
		
	}
	
	public static int min(int num1, int num2) {
				
		return num1<num2?num1 : num2;
	}
	
}
