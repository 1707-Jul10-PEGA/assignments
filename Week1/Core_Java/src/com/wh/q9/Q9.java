package com.wh.q9;

import java.util.ArrayList;

public class Q9 {
	public static void main(String[]args){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++){
			nums.add(i);
		}
		boolean prime;
		for(Integer i: nums){
			prime = true;
			for(int j = 2; j < i/2; j++){
				if(i%j == 0){
					prime = false;
					break;
				}
			}
			if(prime){
				System.out.println(i);
			}
		}
	}
}
