package com.as.q9;

import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		printPrimes(nums);
	}
	
	private static void printPrimes(ArrayList<Integer> l) {
		//add the numbers 1 - 100 to the ArrayList
		for (int i = 1; i < 101; i++) {
			l.add(i);
		}
		//print out the prime numbers from the ArrayList
		for (int i = 0; i < l.size(); i++){
			if (l.get(i) % 2 == 1) {
				
			}
		}
	}
}
