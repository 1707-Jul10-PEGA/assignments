package com.wh.q12;

public class Q12 {
	public static void main(String args[]){
		int[] nums = new int[100];
		for(int i = 0; i < nums.length; i++){
			nums[i] = i+1;
		}
		for(int i: nums){
			System.out.println(i);
		}
	}
}
