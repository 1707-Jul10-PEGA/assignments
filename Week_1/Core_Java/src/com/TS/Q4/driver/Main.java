/*
 * Tae Song
 * Question 4
 */
package com.TS.Q4.driver;

public class Main {
	
	public static void main(String[] args)
	{
		Main Q4 = new Main();
		
		/*Tests out computerFactorial*/
		System.out.println(Q4.computeFactorial(3));
	}
	
	/* compute Factorial
	 * 
	 * takes in an integer and computes its factorial
	 * 
	 * returns the value of the factorial
	 */
	public int computeFactorial(int n)
	{
		int total = 1;
		for(int i = 1; i <= n; i++)
		{
			total = total * i;
		}
		return total;
	}
}
