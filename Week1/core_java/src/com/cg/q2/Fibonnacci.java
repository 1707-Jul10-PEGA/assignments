package com.cg.q2;

public class Fibonnacci {

	public static void main(String[] args) {
		Fibonnacci f = new Fibonnacci();
		f.printFibonnaci(100);
	}

	//Prints out the fibonnaci sequence
	public void printFibonnaci(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(fib(i));
		}
	}

	//Returns the Fibonnaci for n using recursion
	public int fib(int n) {
		// Base Cases
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		// If n is greater than 1
		else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
