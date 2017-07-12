package com.cg.q15;

public class BasicCalculatorTestClass {

	public static void main(String[] args) {
		BasicCalculator calculator = new BasicCalculator();
		
		System.out.println("5 + 6 = "+calculator.addition(5, 6));
		System.out.println("5 - 6 = "+calculator.substraction(5, 6));
		System.out.println("5 * 6 = "+calculator.multiplication(5, 6));
		System.out.println("5 / 6 = "+calculator.division(5, 6));
		

	}

}
