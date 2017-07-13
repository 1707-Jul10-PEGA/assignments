package com.jntm.q15.driver;

public class Calculator implements FourFunction {

	public static void main(String[] args) {
		//Make a 4 function calculator
		//Here's some test cases.
		Calculator x = new Calculator();
		System.out.println(x.add(10,10));
		System.out.println(x.sub(50,35));
		System.out.println(x.mul(99, 0));
		System.out.println(x.div(36, 6));
		
		
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		System.out.print(a + " + " + b + " = ");
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		System.out.print(a + " - " + b + " = ");
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		System.out.print(a + " * " + b + " = ");
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		if(b==0){
			System.out.print("Don't divide by zero.");
			return 0;
		}
		System.out.print(a + " / " + b + " = ");
		return a/b;
	}

}
