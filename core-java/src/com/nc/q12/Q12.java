package com.nc.q12;

public class Q12 {

	public static void main(String[] args) {
		// Create and fill in the array
		int[] array = new int[100];
		for(int x = 1; x <= 100; x++)
		{
			array[x-1] = x;
		}
		
		//number of loops equal number of elements
		for(int element : array)
		{
			//If remainder is 0, the it is and even number
			if(element % 2 == 0)
			{
				System.out.println(element);
			}
		}
	}

}
