package com.jntm.q10.driver;

public class Main {
	public static void main(String[] args) {
		// Find minimum of two numbers with ternary operators.
		System.out.println(smaller(8, 9));
		System.out.println(smaller(15, 7));
	}

	public static int smaller(int a, int b) {
		// If a is less than b, return a, else b.
		return (a < b) ? a : b;

	}

}
