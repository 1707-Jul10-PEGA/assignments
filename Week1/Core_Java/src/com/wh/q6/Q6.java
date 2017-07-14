package com.wh.q6;

/**
 * Q6. Write a program to determine if an integer is even without using the
 * modulus operator(%)
 * 
 * @author Wei Huang
 *
 */
public class Q6 {

	/**
	 * The evenCheck method checks the lowest bit of integer i to see if i is
	 * even or not.
	 * 
	 * @param i
	 *            int to be checked if even
	 * @return true if even
	 */
	private static boolean evenCheck(int i) {
		if (Integer.lowestOneBit(i) != 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(evenCheck(143));// check odd
		System.out.println(evenCheck(126));// check even
	}

}
