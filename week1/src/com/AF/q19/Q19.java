package com.AF.q19;

import java.util.ArrayList;

public class Q19 {

	public static void main (String[] args) {
		
		boolean[] isPrime = new boolean[10];
		for (int i = 0; i < 10; i ++) {
			isPrime[i] = true;
		}
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 1; i < 11; i ++) {
			nums.add(i);
		}
		int even_sum = 0;
		int odd_sum = 0;
		
		for (int i = 1; i < 11; i ++) {
			if (i % 2 == 0) {
				even_sum += i;
			}
			else {
				odd_sum += i;
			}
			
			for (int j = 2; j < ((double)i/2) + 1; j++) {
				
				if (i % j == 0) {
					isPrime[i-1] = false;
					break;
				}
			}
		}
		ArrayList<Integer>notPrime = new ArrayList<Integer>();
		for (int i = 0; i < 10; i ++) {
			if (!isPrime[i]) {
				notPrime.add(i+1);
			}
		}
		for (int n : notPrime) {
			System.out.println(n);
		}
		System.out.println(even_sum);
		System.out.println(odd_sum);
		
	}
}