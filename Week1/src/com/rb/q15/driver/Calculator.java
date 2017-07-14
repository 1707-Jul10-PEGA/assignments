package com.rb.q15.driver;

public class Calculator implements FourFunctionCalc {

	@Override
	public double addition(double x, double y) {
		return x + y;
	}

	@Override
	public double subtraction(double x, double y) {
		return x - y;
	}

	@Override
	public double multiplication(double x, double y) {
		return x * y;
	}

	@Override
	public double division(double x, double y) {
		return x / y;
	}

}
