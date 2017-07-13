package com.dv.q12.driver;

public class EvenNumbers {

	public static void printEvenNumbers(int[] origArray) {
		for(int i : origArray) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
	}
	
	public static void printArray(int[] origArray) {
		for(int i : origArray) {
			System.out.println(i);
		}
	}
		

	public static int[] initOrigArray() {
		int[] origArray = new int[100];
		int number = 1;
		
		for(int i=0; i<100; i++) {
			origArray[i] = number;
			number++;
		}
		
		return origArray;
	}

	public static void main(String[] args) {
		int[] origArray = initOrigArray();

		System.out.println("Original array: ");
		printArray(origArray);
		
		System.out.println("\nPrinting out even numbers: ");
		printEvenNumbers(origArray);
	}

}
