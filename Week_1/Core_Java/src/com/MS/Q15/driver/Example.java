package com.MS.Q15.driver;
/*
 * The interface just sets up the required functions for the class that
 * implements it. In this case, Example must have the outlined four functions.
 */
interface setup
{
	public int add(int a, int b);
	public int sub(int a, int b);
	public int mult(int a, int b);
	public int div(int a, int b);
}

public class Example implements setup{
	public int add(int a, int b)
	{
		return a + b;
	}
	public int sub(int a, int b)
	{
		return a - b;
	}
	public int mult(int a, int b)
	{
		return a * b;
	}
	public int div(int a, int b)
	{
		return a / b;
	}
}

