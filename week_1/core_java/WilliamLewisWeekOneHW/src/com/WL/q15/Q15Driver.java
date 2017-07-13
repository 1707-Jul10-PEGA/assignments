package com.WL.q15;

public class Q15Driver {

	public static void main(String[] args) {
		double o1 = 12.32;
		double o2 = 8923852;
		
		Calculator<Double> c = new Calculator<Double>();

		
		
		System.out.println(c.add(o1, o2));
		System.out.println(c.subtract(o1, o2));
		System.out.println(c.multiply(o1, o2));
		System.out.println(c.divide(o1, o2));
	}

}
