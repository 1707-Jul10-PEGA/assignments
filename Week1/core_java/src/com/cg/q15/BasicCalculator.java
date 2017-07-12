package com.cg.q15;

public class BasicCalculator implements BasicCalculatorInterface{

	@Override
	public double addition(double x, double y) {
		return x + y;
		
	}

	@Override
	public double substraction(double x, double y) {
		return x-y;
		
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

