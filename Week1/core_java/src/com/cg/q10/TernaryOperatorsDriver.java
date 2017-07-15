package com.cg.q10;

public class TernaryOperatorsDriver {
	public static void main(String[] args) {
		TernaryOperators t = new TernaryOperators();

		System.out.print("What's the minimum value of 3 and 5: ");
		System.out.println(t.minValue(3, 5));
		System.out.print("What's the minimum value of 5 and 1: ");
		System.out.println(t.minValue(5, 1));
	}
}
