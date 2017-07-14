package com.aq.q1.driver;
import java.util.ArrayList;
import java.util.List;

public class Question_Two {
	
	List<Integer> memo = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		System.out.print();
	}
	

	public int[] fibHelp(int n) {
		int[] memo = new int[n];
		fibonacci(n,memo);
		// Initialize 
	}
	
	private int fibonacci(int n,int[] memo) {
		int f = n;
		if(memo[f] == 0) {
			return 0;
		}
		else {
			if (n == 1) {
				memo[f] = 1;
				return 1;
			}
			else{
				memo[f] = fibonacci(f - 1,memo) + fibonacci(f - 2,memo);
				return memo[f];
			}
		}
	}
}

