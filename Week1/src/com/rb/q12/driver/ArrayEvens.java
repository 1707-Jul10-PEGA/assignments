package com.rb.q12.driver;

public class ArrayEvens {
	public static void main(String args[]){
		
		// create array with 100 elements
		int[] group = new int[100];
		
		// populate array with values 1 through 100
		for(int i=0; i <100; i++){
			group[i] = i+1;
		}
		
		// print out all numbers divisible by two
		for(int number : group){
			if(number%2 == 0){
				System.out.print(number + " ");
			}
		}
	}
}
