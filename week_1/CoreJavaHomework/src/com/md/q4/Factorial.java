package com.md.q4;

import java.util.Scanner;

public class Factorial {

	/*
	 * Write a program to compute N factorial
	 * 
	 *Factorial list for reference
	 0! 	 1  
	 1! 	 1
	 2! 	 2
	 3! 	 6
	 4! 	 24
	 5! 	 120
	 6! 	 720
	 7! 	 5040
	 8! 	 40320
	 9! 	 362880
	 ..
	 ..
	 ...
	 * 
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to calculate its factorial: ");
		int n = sc.nextInt();
		System.out.println("Factorial of: " + n + " is: " + factorial(n));
	}

	/* Recursive factorial */
	public static int factorial(int n) {
		// base case
		if (n == 0 || n == 1) {
			return 1;
		}
		// recursive case
		else
			return n * factorial(n - 1);
	}
}
