package com.WL.q1;

import java.util.Arrays;

public class QuestionOne {
	// Perform a bubble sort on the following integer array:
	// 1,0,5,6,3,2,3,7,9,8,4

	public static void main(String[] args) {
		int input[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		while (!(makePass(input) == 0)) {
		}
	}

	/**
	 *  array of ints to be sorted, note this only makes a single pass
	 *            on the array, swapping neighboring values into ascending order
	 * @return returns the number of swaps made in iterating through the array.
	 */
	public static int makePass(int[] myArray) {
		int swaps = 0;
		int size = myArray.length;
		// Array loop
		for (int i = 0; i < size - 1; i++) {
			if (myArray[i] > myArray[i + 1]) {
				// Swap the values and increment the swaps counter
				int temp = myArray[i];
				myArray[i] = myArray[i + 1];
				myArray[i + 1] = temp;
				swaps++;
			}
		}
		// Purely for tracking purposes
	 System.out.println(Arrays.toString(myArray));
		return swaps;
	}

}
