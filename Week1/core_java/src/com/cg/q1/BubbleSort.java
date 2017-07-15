package com.cg.q1;

public class BubbleSort {

	// Sort an integer array using bubble sort
	public int[] bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {

				/*
				 * If the next int is less than the current, swap places.
				 */
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}

		return arr;
	}

	// Prints out an int array
	public void printArray(int[] arr) {
		System.out.print("[");
		for (int k : arr) {
			if (k == arr[arr.length - 1]) {
				System.out.print(k);
			} else {
				System.out.print(k + ",");
			}
		}
		System.out.println("]");
	}

}
