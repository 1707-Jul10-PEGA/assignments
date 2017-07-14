package com.wh.q19;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Q19. Create an ArrayList and insert integers 1 through 10. Display the
 * ArrayList. Add all the even numbers up and display the result. Add all the
 * odd numbers up and display the result. Remove the prime numbers from the
 * ArrayList and print out the remaining ArrayList.
 * 
 * @author Wei Huang
 *
 */
public class Q19 {

	private static boolean prime(int x) {
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>(10);
		for (int i = 1; i <= 10; i++) {
			nums.add(i);
		}

		System.out.println("original list: " + nums);
		int even = 0;
		int odd = 0;

		Iterator<Integer> itNums = nums.iterator();
		while (itNums.hasNext()) {
			int i = itNums.next();
			if (i % 2 == 0) {
				even += i;
			} else {
				odd += i;
			}
			if (prime(i)) {
				itNums.remove();
			}
		}

		System.out.println("sum of evens: " + even);
		System.out.println("sum of odds: " + odd);
		System.out.println("List after removing primes: " + nums);
	}
}
