package com.wh.q1;

/**
 * Q1. Perform a bubble sort on the following integer array:
 * 1,0,5,6,3,2,3,7,9,8,4
 * 
 * @author Wei Huang
 *
 */
public class Q1 {

	/**
	 * Bubble Sort for integers.
	 * 
	 * @param nums
	 *            - the array to be sorted.
	 * @return sorted array of integers.
	 */
	private static int[] bubbleSort(int[] nums) {

		int temp;
		int n = nums.length;
		int i = 0;

		while (n != 1) {

			// swaps if 1st number is smaller than the 2nd.
			if (nums[i] > nums[i + 1]) {
				temp = nums[i + 1];
				nums[i + 1] = nums[i];
				nums[i] = temp;
			}

			// increment i to get the next elements in the array in the next
			// loop.
			i++;

			// restart loop from first index after reaching the end of the
			// array.
			// decrement n by 1 since the last number in the array is sorted.
			if (i == n - 1) {
				i = 0;
				n--;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		nums = bubbleSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
