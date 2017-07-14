package com.aq.q15.driver;

public class Driver {
	public static void main(String[] args) {
		CalculatorChild myCalc = new CalculatorChild();
		int a = 5;
		int b = 6;
		System.out.println(myCalc.add(a, b));
		System.out.println(myCalc.sub(a, b));
	
	}
}
