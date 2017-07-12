package com.EC.q1;

public class Q1 {
	
	public static void main(String[] args){
		int[] test = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		System.out.println("Before Bubble Sort");
		printArray(test);
		bubbleSort(test);
		System.out.println("After Bubble Sort");
		printArray(test);
	}

	public static void bubbleSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					swap(array, i, j);
				}
			}
		}
	}

	public static void printArray(int[] test) {
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]);
			if (i != test.length) {
				System.out.print(',');
			}
		}
		System.out.println();
	}

	private static void swap(int array[], int bigVal, int smallVal) {
		int tmp = array[bigVal];
		array[bigVal] = array[smallVal];
		array[smallVal] = tmp;
	}
}
