package com.wh.q2;

/**
 * Write a program to display the first 25 Fibonacci numbers  beginning with 0.
 * @author - Wei Huang
 * 
 */
import java.util.ArrayList;

public class Q2 {

	public static void main(String args[]) {

		// Create our ArrayList to store Fibonacci numbers.
		ArrayList<Integer> fibNums = new ArrayList<Integer>();

		// Give first 2 Fibonacci numbers starting with 0;
		fibNums.add(0);
		fibNums.add(1);

		// Add Fibonacci numbers to ArrayList.
		for (int i = 1; i < 24; i++) {
			fibNums.add(fibNums.get(i) + fibNums.get(i - 1));
		}

		// Print out numbers in ArrayList
		System.out.print(fibNums.toString());
	}
}
