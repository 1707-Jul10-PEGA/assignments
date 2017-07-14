package com.HL.q19;

import java.util.ArrayList;

public class Question19
{
	public static void main(String[] args)
	{
		int sumEven=0, sumOdd=0;
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i=1; i<=10; i++)
		{
			arrList.add(i);
		}
		System.out.println("My ArrayList is: "+arrList);
		for(int i=0; i<arrList.size(); i++)
		{
			if(arrList.get(i)%2==0)
			{
				sumEven += arrList.get(i);
			}
			else
			{
				sumOdd += arrList.get(i);
			}
		}
		System.out.println("The sum of all even number is: "+sumEven);
		System.out.println("The sum of all odd number is: "+sumOdd);
		ArrayList<Integer> nonPrimeList = new ArrayList<>();
		int temp;
		for(int x: arrList)
		{
			for(int i=2; i<=x/2; i++)
			{
				temp = x%i;
				if(temp==0)
				{
					nonPrimeList.add(x);
					break;
				}
			}
		}
		System.out.println("List after prime numbers removed: "+nonPrimeList);
	}
}
