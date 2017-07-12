package com.as.q12;

public class Driver {

	public static void main(String[] args){
		//an array to store all of the numbers in
		int[] nums = new int[100];
		//stores numbers in the array and prints it
		storeAndPrint(nums);
		
	}
	
	/*
	 * Stores numbers 1 to 100 in an array
	 */
	private static void storeAndPrint(int[] n) {
		//checks that the array is big enough to hold the numbers
		if (n.length < 100) {
			return;
		}
		
		//stores numbers 1 to 100 in the array
		for(int i = 0; i < 100; i++){
			n[i] = i + 1;
		}
		
		//prints out the even numbers in 1 to 100
		for(int i: n){
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
}
