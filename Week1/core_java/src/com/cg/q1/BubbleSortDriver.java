package com.cg.q1;

public class BubbleSortDriver {
	public static void main(String[] args) {

		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		BubbleSort b = new BubbleSort();

		b.printArray(arr);
		b.printArray(b.bubbleSort(arr));

	}
}
