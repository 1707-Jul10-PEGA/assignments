package com.as.q2;

public class Driver {

	public static void main(String[] args){
		int fibNum = 25;
		
		//this for loop will print out the first fibNum fibonacci numbers
		for(int i = 0; i < fibNum; i++){
			System.out.println(fibonacci(i));
		}
	}
	
	/*
	 * Private method that returns the nth fibonacci number where numFib = n
	 * i.e. if numFib = 4 it will return 3
	 */
	private static int fibonacci(int numFib){
		if (numFib > 1){
			return fibonacci(numFib - 1) + fibonacci(numFib - 2);
		} else if(numFib == 1) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
