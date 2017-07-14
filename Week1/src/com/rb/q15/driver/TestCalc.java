package com.rb.q15.driver;

public class TestCalc {
	
	private static double x = 129.0;
	private static double y = 100.0;
	
	public static void main(String[] args) {
		// creates a calculator, then runs the four functions
		Calculator calculate = new Calculator();
		System.out.format("x = %.3f%n", x);
		System.out.format("y = %.3f%n", y);
		System.out.format("x+y = %.3f%n", calculate.addition(x, y));
		System.out.format("x-y = %.3f%n", calculate.subtraction(x, y));
		System.out.format("x*y = %.3f%n", calculate.multiplication(x, y));
		System.out.format("x/y = %.3f%n", calculate.division(x, y));
	}
}
