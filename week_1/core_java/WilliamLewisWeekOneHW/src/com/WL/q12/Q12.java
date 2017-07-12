package com.WL.q12;

public class Q12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Generate array of ints
		int[] myInts = new int[100];
		for(int i = 0; i < 100; i++)

		{
			myInts[i] = i +1;
		}
		//Print out the numbers divisible by 2
		for(int i : myInts)
		{
			if( i % 2 == 0)
			{
				System.out.print(i + " ");
			}
		}
		
	}

}
