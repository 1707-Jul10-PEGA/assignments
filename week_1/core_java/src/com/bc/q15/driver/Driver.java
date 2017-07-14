package com.bc.q15.driver;

interface Arithmetic {
	public double addition(double x, double y);

	public double subtraction(double x, double y);

	public double multiplication(double x, double y);

	public double division(double x, double y);
}

public class Driver {
	public static void main(String[] args) {
		Arithmetic ari = new Arith();
		System.out.println(ari.addition(20, 30));
		System.out.println(ari.addition(3, 8));
		System.out.println(ari.subtraction(20, 14));
		System.out.println(ari.multiplication(6, 5));
	}
}

class Arith implements Arithmetic {

	@Override
	public double addition(double x, double y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public double subtraction(double x, double y) {
		// TODO Auto-generated method stub
		return x - y;
	}

	@Override
	public double multiplication(double x, double y) {
		// TODO Auto-generated method stub
		return x * y;
	}

	@Override
	public double division(double x, double y) {
		// TODO Auto-generated method stub
		return x / y;
	}

}
