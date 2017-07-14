package com.wh.q4;

/**
 * Q4. Write a program to compute N factorial.
 * 
 * @author Wei Huang
 *
 */
public class Q4 {

    /**
     * Calculate the nth factorial given the number n.
     * @param n
     *            - a value.
     * @return the factorial of the given value.
     */
    private static int factorial(int n) {
	if (n > 12) {
	    System.out.println("n too big, this program curretly can't handle n>12.");
	    return 0;
	}
	if (n == 1) {
	    return 1;
	}
	return n * factorial(n - 1);
    }

    public static void main(String args[]) {
	System.out.print(factorial(12));
    }
}
