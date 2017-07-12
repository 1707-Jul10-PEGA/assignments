package com.as.q4;

public class Driver {

	public static void main(String[] args){
		//the number to factorize
		int n = 5;
		//stores the factorial of n
		int factorialN = factorial(n);
		//prints n and its factorial
		System.out.println(factorialN + " is the factorial of " + n);
		
	}
	
	/*
	 * Calculates the factorial of the parameter passed into the method
	 */
	private static int factorial(int n){
		if (n > 0) {
			return factorial(n - 1) * n;
		} else {
			return 1;
		}
	}
}
