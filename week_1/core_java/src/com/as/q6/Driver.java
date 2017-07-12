package com.as.q6;

public class Driver {

	public static void main(String[] args){
		//an even number to test
		int odd = 17;
		//an odd number to test
		int even = 28;
		//print out the results for the odd number
		System.out.println(isEven(odd));
		//print out the results for the even number
		System.out.println(isEven(even));
	}
	/*
	 * checks if a number is even and returns true if it is and false otherwise
	 */
	private static boolean isEven(int x){
		//divide the number by 2 then multiply it by 2
		//and assign it to a new variable
		int y = (x / 2) * 2;
		//if the new number equals the old number then the number is even
		//otherwise it is odd
		return x == y;
	}
	
}
