package com.MS.Q6.driver;

public class Modulus {

	/*
	 * The isEven function determines whether the given number is even or not. It does this
	 * by creating a double (y) with the exact same value as the supplied integer (x). It
	 * then divides them both by two and compares the output values. If they match, the
	 * integer is even and will return true. If not, the double will have a non-integer 
	 * value and will return as false.
	 */
	public boolean isEven(int x)
	{
		double y = x;
		x = x/2;
		y = y/2;
		System.out.println("Half of x (int) is: " + x);
		System.out.println("Half of y (dbl) is: " + y);
		if(x == y)
			return true;
		else
			return false;
		
	}
	public static void main(String[] args) {

		Modulus Example = new Modulus();
		int testnum = 11;
		boolean answer;
		System.out.println("The number to be tested is: " + testnum);
		answer = Example.isEven(testnum);
		System.out.println("Is this value even? " + answer);
	}

}
