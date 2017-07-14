package com.rb.q12.driver;

public class ArrayEvens {
	public static void main(String args[]){
		
		int[] group = new int[100];
		
		for(int i=0; i <100; i++){
			group[i] = i+1;
		}
		
		for(int number : group){
			if(number%2 == 0){
				System.out.print(number + " ");
			}
		}
	}
}
