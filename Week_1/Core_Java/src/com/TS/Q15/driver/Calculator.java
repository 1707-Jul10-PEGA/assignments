/*
 * Tae Song
 * Question 15 - Calculator class implemented using BasicArithmetic interface
 */
package com.TS.Q15.driver;

/*
 * This class provides basic arithmetic operations such as addition, subtraction, etc
 */
public class Calculator implements BasicArithmetic {

	@Override
	public int addition(int x, int y) {
		return x + y;
	}

	@Override
	public int subtraction(int x, int y) {
		return x - y;
	}

	@Override
	public int multiplication(int x, int y) {
		return x * y;
	}

	@Override
	public int division(int x, int y) {
		return x / y;
	}
}
