package com.MS.Q12.driver;

public class Evens {
	
	/*
	 * The main function fills a new integer array with numbers from 1 to 100.
	 * It then uses an enhanced for loop to find all integer values in the
	 * array. Once it has done that, it prints out either a " " or the number
	 * depending on whether or not said number is even.
	 */
	public static void main(String[] args) {
		int[] example = new int[100];
		for(int i=0; i<100; i++)
		{
			example[i] = i+1;
		}
		
		for(int i: example)
		{
			System.out.print((i%2)==0?i:" ");
		}
	}

}
