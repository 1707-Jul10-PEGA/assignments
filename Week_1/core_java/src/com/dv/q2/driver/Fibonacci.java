package com.dv.q2.driver;

public class Fibonacci {
	
	public static void fib() {
		int len = 25;
		int left = 0, right = 1, res = 0;
		
		System.out.print(left + " " + right + " ");
		
		// start at 2 because first two values are already printed out
		for(int i=2; i<len; i++) {
			res = left + right;
			System.out.print(res + " ");
			
			left = right;
			right = res;
		}
	}
	
	public static void main(String[] args) {
		fib();
	}

}
