package com.as.q15.driver;

import com.as.q15.calculator.FourFunctionCalculator;

public class Driver {
	public static void main(String[] args) {
		System.out.println("Testing addition:");
		FourFunctionCalculator<Integer> calc = new FourFunctionCalculator<Integer>();
		int a = 23;
		int b = 42;
		System.out.println(a + " + " + b + " = " + calc.addition(a, b));
		System.out.println("Testing subtraction:");
		System.out.println(a + " - " + b + " = " + calc.subtraction(a, b));
	}
}
