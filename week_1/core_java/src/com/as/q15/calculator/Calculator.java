package com.as.q15.calculator;

public interface Calculator<T extends Number> {

	public T addition(T a, T b);
	
	public T subtraction(T a, T b);
	
	public T multiplication(T a, T b);
	
	public T division(T a, T b);
}
