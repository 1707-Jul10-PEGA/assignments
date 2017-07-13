package com.WL.q4;

import java.math.BigInteger;

public class QFour {
		//Write a program to compute N factorial
	// BIg Integer is used to avoid limitations of using an int.
	public static void main(String[] args) {
		
			
	BigInteger myVal = new BigInteger("15");
	
	BigInteger blue = factorial(myVal);
	System.out.println(blue);
	}
	public static BigInteger factorial(BigInteger myInt)
	{
		//Base case
		if((BigInteger.ONE).equals(myInt))
		{
			return (BigInteger.ONE);
		}
		//Otherwise return value * one less than value
		return (factorial(myInt.subtract(BigInteger.ONE))).multiply(myInt);

	}
	
}
