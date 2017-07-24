package com.HL.q9;

import java.util.ArrayList;

public class Question9
{
	public static void main(String[] args)
	{
		ArrayList<Integer> myList = new ArrayList<>();
		for(int i=1; i<=100; i++)
		{
			myList.add(i);
		}
		ArrayList<Integer> nonPrimeList = new ArrayList<>();
		int temp;
		for(int x: myList)
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
		myList.removeAll(nonPrimeList);
		myList.remove(0);
		System.out.println("Prime list from 1 to 100:");
		System.out.println(myList);
	}
}
