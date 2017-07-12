package com.AF.q15;

interface IntMath {
	int addition (int a, int b);
	
	int subtraction(int a, int b);
	
	int multiplication(int a, int b);
	
	double division (int a, int b);
}


class MathObject {
	int addition (int a, int b) {
		return a + b;
	}
	
	int subtraction(int a, int b) {
		return a - b;
	}
	
	int multiplication(int a, int b) {
		return a * b;
	}
	
	double division (int a, int b) {
		return (double)a / (double)b;
	}
}

public class Q15 {
	public static void main(String[] args) {
		MathObject mo = new MathObject();
		System.out.println(mo.addition(1,5));
		System.out.println(mo.division(1,5));
	}
}
