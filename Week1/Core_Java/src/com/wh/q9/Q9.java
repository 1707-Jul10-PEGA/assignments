package com.wh.q9;

import java.util.ArrayList;

/**
 * Q9. Create an ArrayList which stores numbers from 1 to 100 prints out all the
 * prime numbers to the console.
 * 
 * @author Wei Huang
 *
 */
public class Q9 {

    /**
     * Method to check if an integer is a prime number.
     * 
     * @param i
     *            - The number passed in to be checked.
     * 
     * @return - True if prime and false otherwise.
     */
    public static boolean isPrime(int i) {
	if (i == 1)
	    return false;
	for (int j = 2; j <= Math.sqrt(i); j++) {
	    if (i % j == 0) {
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args) {

	ArrayList<Integer> nums = new ArrayList<Integer>();

	// Add numbers 1 - 100 into ArrayList
	for (int i = 1; i <= 100; i++) {
	    nums.add(i);
	}

	// For each Integer i in ArrayList nums print out i if
	for (Integer i : nums) {
	    if (isPrime(i)) {
		System.out.println(i);
	    }
	}
    }
}
