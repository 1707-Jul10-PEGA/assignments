package com.jntm.q12.driver;

public class Main {

	public static void main(String[] args) {
		//Store 1-100 in array, print evens.
		
		//Array made
		int[] arr = new int[100];
		
		//Filled with numbers
		for(int x=1; x<=100; x++){
			arr[x-1]=x;
		}
		
		//Print evens.
		for(int x : arr){
			if(x%2==0){
				System.out.println(x);
			}
		}
				
		
	}

}
