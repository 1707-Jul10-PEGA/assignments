/*
 * Tae Song
 * Question 6
 */
package com.TS.Q6.driver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myIsEven(4);
		myIsEven(5);
	}
	
	/* myIsEven
	 * 
	 * takes in an integer and check to see if it is even without using % operator
	 * 
	 * outputs whether the integer is even or odd
	 */
	public static void myIsEven(int x)
	{
		if ( (x & 1) == 0)
		{ System.out.println("This integer is even"); }
		else
		{ System.out.println("This integer is odd");}
	}
}
