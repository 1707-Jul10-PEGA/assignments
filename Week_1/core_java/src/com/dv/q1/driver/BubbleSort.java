package com.dv.q1.driver;

public class BubbleSort {
	
	public static void printArray(int[] myArray) {
		for(int i=0; i<myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
		
		System.out.println();
	}
	
	public static void bubbleSort() {
		
		int i = 0, j = 0, temp = 0;
		int[] myArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		System.out.println("Original array: ");
		printArray(myArray);
		
		for(i=0; i<myArray.length; i++) {
			for(j=1; j<myArray.length; j++) {
				
				// look behind index j and compare
				if(myArray[j-1] > myArray[j]) {
					temp = myArray[j-1];
					myArray[j-1] = myArray[j];
					myArray[j] = temp;
					printArray(myArray);
				}
			}
		}
		
		System.out.println("Sorted array: ");
		printArray(myArray);
	}
	
	public static void main(String[] args) {
		bubbleSort();
	}

}