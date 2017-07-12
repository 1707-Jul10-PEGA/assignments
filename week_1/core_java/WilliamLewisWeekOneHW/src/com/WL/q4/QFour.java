package com.WL.q4;


public class QFour {
		//Write a program to compute N factorial
	
	public static void main(String[] args) {
		
	
	
	int blue = factorial(5);
	System.out.println(blue);
	}
	public static int factorial(int myInt)
	{
		
		if(myInt == 1)
		{
			return (1);
		}
		return factorial(myInt-1) * myInt;

	}
}
