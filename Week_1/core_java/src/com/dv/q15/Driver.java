package com.dv.q15;

public class Driver {
	
	public static void main(String[] args) {
		Calculator<Integer> intCalc= new Calculator<Integer>();
		Calculator<Double> dblCalc = new Calculator<Double>();
		
		System.out.println("5 + 8 = " + intCalc.add(5, 8));
		System.out.println("5 - 8 = " + intCalc.subtract(5, 8));
		System.out.println("5.0 * 8.0 = " + dblCalc.multiply(5.0, 8.0));
		System.out.println("40.0 / 8.0 = " + dblCalc.divide(40.0, 8.0));
	}

}
