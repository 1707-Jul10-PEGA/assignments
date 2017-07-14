package com.md.q15;

/**
 * Write a program that defines an interface having the following methods:
 * addition, subtraction, multiplication and division. Create a class that
 * implements this interface and provides appropriate functionality to carry out
 * the required operations. Hard code two operands in a test class having the 
 * main method that calls the implementation class.
 * 
 * @author Martin Delira
 *
 */

public class CalculatorTester {
	public static void main(String[] args) throws Exception {

		Calculator calculator = new Calculator();
		
		int a = 19;
		int b = 20;
		
		int addition = calculator.addition(a, b);
		int substraction = calculator.substraction(a, b);
		int multiplication = calculator.multiplication(a, b);
		double division  = calculator.division(a, b);
		
		System.out.println("Results are:");
		System.out.println("Addition:" + addition);
		System.out.println("Substraction:" + substraction);
		System.out.println("Multiplication:" + multiplication);
		System.out.println("Division:" + division);
		
	}
}
