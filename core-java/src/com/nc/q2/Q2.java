package com.nc.q2;

public class Q2 {
	public static void main(String[] args){
		//hold the fibonacci numbers
		int fibonacci[] = new int[25];
		//the first two fibonacci numbers
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		//Get the rest of the fibonacci numbers
		for(int x = 2; x < 25; x++)
		{
			fibonacci[x] = fibonacci[x-1] + fibonacci[x-2];
		}
		//Display results
		for(int z = 0; z < 25; z++)
		{
			System.out.print(fibonacci[z] + ", ");
		}
	}

}
