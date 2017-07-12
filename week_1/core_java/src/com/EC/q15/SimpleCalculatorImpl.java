package com.EC.q15;

public class SimpleCalculatorImpl implements SimpleCalculator{

	@Override
	public int addition(int n, int... add) {
		if(n==0){
			return 0;
		}
		return add[n] + add[n-1];
	}

	@Override
	public int substraction(int n, int... sub) {
		if(n==0){
			return 0;
		}
		return sub[n] - sub[n-1];
	}

	@Override
	public int multiplication(int n, int... mult) {
		if(n==0){
			return 0;
		}
		return mult[n] + mult[n-1];
	}

	@Override
	public int division(int top, int bottom) {
		return top/bottom;
	}

	

}
