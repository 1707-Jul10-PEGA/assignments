package com.as.q10;

public class Driver {

	public static void main(String[] args) {
		//the bigger value to find the minimum of
		int max = Integer.MAX_VALUE;
		//the smaller value to find the minimum of
		int min = Integer.MIN_VALUE;
		//print out the minimum of the two numbers
		System.out.println(min(max, min));
	}
	
	/*
	 * find the minimum of two numbers
	 */
	private static int min(int x, int y){
		if (x < y) {
			return x;
		} else {
			return y;
		}
	}
}
