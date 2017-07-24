package com.HL.q12;

public class Question12
{
	public static void main(String[] args)
	{
		int[] myArr= new int[100];
		for(int i=1; i<=100; i++)
		{
			myArr[i-1] = i;
		}
		for(int myInt : myArr)
		{
			if(myInt%2==0)
			{
				System.out.println(myInt);
			}
		}
	}
}
