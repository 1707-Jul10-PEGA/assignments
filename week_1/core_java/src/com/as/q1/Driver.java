package com.as.q1;

import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) {
		//the array to be sorted by the bubble sort
		int[] ary = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		//pass the array to be sorted via bubble sort
		bubbleSortIntArray(ary);
		//print out the sorted array
		System.out.print("[ ");
		for (int i: ary) {
			System.out.print(i + " ");
		}
		System.out.print("]\n");
	}
	
	/*
	 * performs a bubble sort on an int array
	 */
	private static void bubbleSortIntArray(int[] a) {
		int length = a.length;
		//check that the array has at least one member
		if (length > 0) {
			//boolean to mark if a swap occurred
			boolean swapped = false;
			//do runs through the array until no swap occurred
			do {
				//at the start of each run swapped is false
				swapped = false;
				//make a pass through the array
				for (int i = 0; i < length - 1; i++){
					if (a[i] > a[i + 1]) {
						int temp = a[i];
						a[i] = a[i + 1];
						a[i + 1] = temp;
						swapped = true;
					}
				}
			} while(swapped);
		}
	}
}
