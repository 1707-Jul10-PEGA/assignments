package com.dpq15.driver;

public class CalcUser {

	public static void main(String[] args) {
		double x = 4.0;
		double y = 2.0;
		double sum = ActualCalc.addition(x, y);
		double diff = ActualCalc.subtraction(x, y);
		double prod = ActualCalc.multiplication(x, y);
		double quot = ActualCalc.division(x, y);
		System.out.println(sum + " " + diff + " " + prod + " " + quot);
	}
}
