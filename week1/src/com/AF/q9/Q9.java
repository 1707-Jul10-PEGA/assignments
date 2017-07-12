package com.AF.q9;

import java.util.ArrayList;

public class Q9 {
	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 1; i < 101; i ++) {
			nums.add(i);
		}
		
		for (int i = 2; i < 101; i ++) {
			
			boolean prime = true;
			
			for (int j = 2; j < i/2+1; j++) {
				if (i % j == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				System.out.println(i);
			}
		}
	}
	
	
}
