package com.dpq15.driver;

public class ActualCalc implements CalcInt {

	public ActualCalc() {
		
	}
	
	public static double addition(double x, double y) {
		double sum = x + y;
		return sum;
	}
	
	public static double subtraction(double x, double y) {
		double diff = x - y;
		return diff;
	}
	
	public static double multiplication(double x, double y) {
		double prod = x * y;
		return prod;
	}
	
	public static double division(double x, double y) {
		double quot = x / y;
		return quot;
	}

}
