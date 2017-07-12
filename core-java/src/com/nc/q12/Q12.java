package com.nc.q12;

public class Q12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[100];
		
		for(int x = 1; x <= 100; x++)
		{
			array[x-1] = x;
		}
		for(int element : array) //It is not starting at the zeroth element
		{
			if(element % 2 == 0)
			{
				System.out.println(element);
			}
		}
	}

}
