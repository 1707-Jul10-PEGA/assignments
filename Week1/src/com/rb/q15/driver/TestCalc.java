package com.rb.q15.driver;

public class TestCalc {
	
	private static double x = 129.0;
	private static double y = 100.0;
	
	public static void main(String[] args) {
		Calculator calculate = new Calculator();
		System.out.format("x = %.3f", x);
		System.out.format("y = %.3f", y);
		System.out.println(calculate.addition(x, y));
		System.out.println(calculate.subtraction(x, y));
		System.out.println(calculate.multiplication(x, y));
		System.out.println(calculate.division(x, y));
	}
}
