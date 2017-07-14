package com.HL.q2;

public class Question2 
{
	public static void main(String[] args)
	{
		int[] myArr = new int[25];
		myArr[0] = 0;
		myArr[1] = 1;
		for(int i=2; i<25; i++)
		{
			myArr[i] = myArr[i-1] + myArr[i-2];
		}
		System.out.println("The first 25 Fibonacci numbers are:");
		for(int i=0; i<25; i++)
		{
			System.out.print(myArr[i]+" ");
		}
	}
}
