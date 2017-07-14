/*
 * Tae Song
 * Question 2
 */
package com.TS.Q2.driver;

public class Main {
	/*trying out static field variables*/
	public static int count;
	
	/* printFibonacci
	 * 
	 * takes in 3 integers, first 2 integers used as recursive iterators, the third integer
	 * used to know how many recursive calls to make
	 * 
	 * prints out the n fibonacci numbers
	 */
	public void printFibonacci(int a, int b, int n)
	{
		if(count == 1)
		{
			System.out.print(0 + " ");
		}
		if(count == n)
		{
			count = 1;
			System.out.println();
			return;
		}
		count = count + 1;
		System.out.print(b + " ");
		printFibonacci(b, a+b, n);
	}
	
	public static void main(String[] args)
	{
		count = 1;
		Main Q2 = new Main();
		
		/*prints out the fibonacci numbers*/
		System.out.println("Printing out fibonacci numbers...");
		Q2.printFibonacci(0,1,25);
	}
}
