package com.md.q15;

public class Calculator implements CalculatorInterface {

	@Override
	public int addition(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int substraction(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public double division(int a, int b) throws Exception {
		// TODO Auto-generated method stub
		
		if(b == 0) {
			throw new Exception("Cannot divide by 0");
		}
		
		return ((double)a/(double)b);
	}
	
}
