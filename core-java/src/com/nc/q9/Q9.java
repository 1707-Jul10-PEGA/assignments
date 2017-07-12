package com.nc.q9;

import java.util.ArrayList;

public class Q9 {
	public static void main(String[] args) {
		//Create and add onto the list of numbers
		ArrayList aList = new ArrayList();
		for(int x = 1; x <=100; x++)
		{
			aList.add(x);
		}
		//State the first 4 prime numbers
		System.out.print("2, 3, 5, 7,");
		
		//Check numbers between 8 and 100
		for(int y = 7; y < 100; y++)
		{
			//If it is divisible by 2 then exit
			if(y%2 == 0)
			{
				continue;
			}
			//If it is divisible by 3 then exit
			else if(y%3 == 0)
			{
				continue;
			}
			//If it is divisible by 5 then exit
			else if(y%5 == 0)
			{
				continue;
			}
			//If it is divisible by 7 then exit
			else if(y%7 == 0)
			{
				continue;
			}
			//Will print prime numbers
			else
			{
				System.out.print(" " + y + ",");
			}
		}
	}
}
