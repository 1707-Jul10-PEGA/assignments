package com.MS.Q2.driver;

public class Fibonacci {

	/*
	 * This function takes the supplied number (optimally 0), adds 1 to that and stores the
	 * two numbers as the first two numbers in the sequence. It displays those numbers, then
	 * combines them and displays the combination of those two numbers. It repeats to display
	 * the first 25 numbers in the sequence (supplied two inclusive)
	 */
	public void fib(int x)
	{
		int fib1 = x;
		int fib2 = x+1;
		System.out.print(fib1 + " ");
		System.out.print(fib2 + " ");
		for(int i = 1; i < 24; i++)
		{
			int holder = fib2;
			fib2 = fib1 + fib2;
			fib1 = holder;
			System.out.print(fib2 + " ");
		}
	}
	
	/*
	 * The main function simply sets up a new object in order to run the .fib command. It also 
	 * supplies the starting number for the sequence (optimally 0) and then executes .fib
	 * according to the supplied number.
	 */
	public static void main(String[] args)
	{
		Fibonacci Q1 = new Fibonacci();
		int x = 0;
		Q1.fib(x);
	}
}
