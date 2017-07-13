package com.EC.q15;

public class Q15 {
	
	public static void main(String[] args){
		SimpleCalculator calc = new SimpleCalculatorImpl();
		
		System.out.println("1+1 = " + calc.addition(1,1));
		System.out.println("4-4 = " + calc.substraction(4,4));
		System.out.println("4*4 = " + calc.multiplication(4,4));
		System.out.println("4 / 4 = " + calc.division(4, 4));


		
	}
	
}
