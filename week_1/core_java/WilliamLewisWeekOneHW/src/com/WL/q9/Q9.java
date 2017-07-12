package com.WL.q9;

import java.util.ArrayList;

public class Q9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> myInts = new ArrayList<Integer>();
		//Check values 0-100 and add them to an arraylist!
		for(int i = 1; i <= 100; i++)
		{
			if(isPrime(i))
			{
				System.out.print(i + " ");
			}
			myInts.add(i);
		}

	}

	
	public static boolean isPrime(int i){
		for(int j = 2; j <= Math.sqrt(i); j ++ )
		{
			//If this int is divisable by any number up to its sqrt it is composite.
			if(((i%j) == 0))
			{
				return false;
			}
		}
		//Otherwise it is prime.
		return true;
	}
}
