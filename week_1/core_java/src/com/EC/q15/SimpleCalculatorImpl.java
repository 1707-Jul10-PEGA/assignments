package com.EC.q15;

public class SimpleCalculatorImpl implements SimpleCalculator{

	@Override
	public int addition(int n1, int n2) {
		return n1+n2;
	}

	@Override
	public int substraction(int n1, int n2) {
		return n1-n2 ;
	}

	@Override
	public int multiplication(int n1, int n2) {
		return n1*n2;
	}

	@Override
	public int division(int n1, int n2) {
		return n1/n2;
	}



}
