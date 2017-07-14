package com.md.q2;

public class Fibonacci {

	public static void main(String[] args) {
		
		int limit = 25;
		
		System.out.println("Fibonacci of " + limit + " is: " + fib(limit));
	}
	
	
	//recursive fib
	public static int fib(int n) {
		//base case
		if(n == 1) {
			return 1;
		}
		else if (n == 0) {
			return 0;
		}
		
		//recursive case
		else if(n > 1) {
			return fib(n-1) + fib (n-2);
		}
		
		//if there input is something less than 0
		else {
			return -1;
		}
				
	}
	
	
}
