package com.rb.q15.driver;

public class Calculator implements FourFunctionCalc {
	
	// Adds the values
	@Override
	public double addition(double x, double y) {
		return x + y;
	}
	
	// subtracts the values
	@Override
	public double subtraction(double x, double y) {
		return x - y;
	}
	
	// multiplies the values
	@Override
	public double multiplication(double x, double y) {
		return x * y;
	}
	
	// divides the values
	@Override
	public double division(double x, double y) {
		return x / y;
	}

}
