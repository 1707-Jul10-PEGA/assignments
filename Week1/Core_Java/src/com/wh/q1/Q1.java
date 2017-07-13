package com.wh.q1;
/**
 * Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
 * @author Wei Huang
 *
 */

public class Q1 {
	
	/**
	 * Bubble Sort for integers.
	 * @param nums - Array of numbers to be sorted.
	 * @return nums - Returns sorted int sorted array of numbers.
	 */
	private static int[] bubbleSort(int [] nums){
		int temp;
		int n = nums.length;
		int i = 0;
		while(n!=1){
			if(nums[i]>nums[i+1]){ //swaps if 1st number is smaller than the 2nd.
				temp = nums[i+1];
				nums[i+1] = nums[i];
				nums[i] = temp;
			}
			i++;
			if(i == n-1){//restart loop from first index after reaching the end.
				i = 0;
				n--;
			}
		}
		return nums;
	}
	
	public static void main(String[] args){
		int[] nums = {1,0,5,6,3,2,3,7,9,8,4};
		nums = bubbleSort(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i]+" ");
		}
	}
}
