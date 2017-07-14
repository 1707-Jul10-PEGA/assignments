//Jake Maynard
//Print out primes 1-100
package com.jntm.q9.driver;

import java.util.ArrayList;

public class Main {
	// Print all primes 1-100.

	public static void main(String[] args) {
		// Make arraylist
		ArrayList<Integer> nums = new ArrayList<Integer>();

		// Fill it
		for (int x = 0; x < 100; x++) {
			nums.add(x + 1);
		}

		// Identify primes.
		for (int x = 0; x < 100; x++) {
			if (isPrime(nums.get(x))) {
				System.out.println(nums.get(x));
			}
		}

	}

	// This right here is an algorithmic war crime but it gets the job done on
	// the small scale.
	// It works by checking all numbers for divisibility by all preceding
	// numbers.
	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}

		for (int x = 2; x < num; x++) {
			if (num % x == 0) {
				return false;
			}
		}

		return true;
	}
}
