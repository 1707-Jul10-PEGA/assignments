package com.md.q6;

import java.util.Scanner;

/*
 * Write a program to determine if an integer is even without 
 * using the modulus operator (%)
 */
public class EvenOrOdd {

	public static void main(String[] args) {
		System.out.println("Enter a number to determine if is odd or even");
		Scanner sc = new Scanner(System.in);
		System.out.println("Is Even?: " + isEven(sc.nextInt()));
				
	}

	public static boolean isEven(int n) {

		/*
		 * This uses bitwise AND operator. Compares every
		 * bit on the left side with every bit on the right side.
		 * If every bit is the same, result == 1. else == 0;
		 * Logic tells you that if a binary number has a 1 in the 
		 * first bit, then it is odd.
		 */
		
		//checks if is odd, if false, return true (means even)
		if ((n & 1) == 0) {
			return true;
		} else
			return false;

	}

}
