package com.AF.q2;

public class Q2 {
	public static void main(String[] args) {
		int prev_prev = 0;
		int prev = 1;
		int[] result = new int[25];
		result[0] = 0;
		result[1] = 1;
		for(int i=2; i < 25; i++) {
			result[i] = prev_prev+prev;
			prev_prev = prev;
			prev = result[i];
		}
		for (int i = 0; i < 25; i++) 
			System.out.println(result[i]);
	}
}
