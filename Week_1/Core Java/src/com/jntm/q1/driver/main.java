//Author: Jacob Maynard
// July 10th 2017
//Perform a bubble sort on integer array.
package com.jntm.q1.driver;

public class main {

	public static void main(String[] args) {
		int[] given = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		bubbleSort(given);
	}

	public static void bubbleSort(int[] input) {
		int length = input.length;
		int temp = 0;

		
		//Output unsorted array.
		System.out.println("This is the input array:");
		for (int x = 0; x < length; x++) {
			System.out.print(input[x]+" ");
		}
		System.out.println('\n');
		
		//Actually sort it.
		//It's a simple bubblesort
		for (int i = 0; i < length; i++) {
			for (int j = 1; j < (length - i); j++) {
				if (input[j - 1] > input[j]) {
					temp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = temp;
				}
			}

		}

		// Print results of sort:
		System.out.println("This is the output array:");
		for (int x = 0; x < length; x++) {
			System.out.print(input[x]+" ");
		}

	}
}
