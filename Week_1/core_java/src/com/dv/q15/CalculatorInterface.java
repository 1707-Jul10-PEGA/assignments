package com.dv.q15;

public interface CalculatorInterface<T extends Number>{

	public T add(T x, T y);
	
	public T subtract(T x, T y);
	
	public T multiply(T x, T y);
	
	public T divide(T x, T y);

}