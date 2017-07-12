package com.AF.q12;

import java.util.ArrayList;

public class Q12 {
	public static void main (String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i < 101; i++) {
			nums.add(i);
		}
		
		for (int i : nums) {
			if ( i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
}

