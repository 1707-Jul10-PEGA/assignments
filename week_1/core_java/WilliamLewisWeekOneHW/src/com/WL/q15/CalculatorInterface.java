package com.WL.q15;

//Interface designed for the generic Calculator made in class
public interface CalculatorInterface <T extends Number>{
	
	
	public T add(T a, T b);
	public T subtract(T a, T b);
	public T divide(T a, T b);
	public T multiply(T a, T b);
	
	
	
}
