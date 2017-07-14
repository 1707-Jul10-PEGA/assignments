package com.aq.q2.driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
	
	static int[] memo = null;
	
	public static void main(String[] args) {
		fibHelp(25); 
		System.out.println(Arrays.toString(memo));
	}
	
	public static void fibHelp(int n) {
		memo = new int[26];
		System.out.println(n);
		fibonacci(n);
	}
	private static int fibonacci(int n) {
		int f = n;
		if(f == 0) {
			return 0;
		}
		else {
			if (f == 1) {
				memo[f] = 1;
				return 1;
			}
			else{
				memo[f] = fibonacci(f - 1) + fibonacci(f - 2);
				return memo[f];
			}
		}
	}
}

