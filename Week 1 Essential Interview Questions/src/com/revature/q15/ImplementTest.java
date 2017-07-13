package com.revature.q15;

public class ImplementTest implements MathInterface{
	@Override
	public double add(double a, double b){
		return a + b;
	}

	@Override
	public double sub(double a, double b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public double mult(double a, double b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public double div(double a, double b) {
		// TODO Auto-generated method stub
		return a / b;
	}
}
