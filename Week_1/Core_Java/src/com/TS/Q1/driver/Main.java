/*
 * Tae Song
 * Question 1
 */
package com.TS.Q1.driver;

public class Main {
	
	public static void main(String[] args)
	{
		int[] numbersToSort = new int[11]; //array of numbers to sort
		
		/*initializing the array of numbers */
		numbersToSort[0] = 1;
		numbersToSort[1] = 0;
		numbersToSort[2] = 5;
		numbersToSort[3] = 6;
		numbersToSort[4] = 3;
		numbersToSort[5] = 2;
		numbersToSort[6] = 3;
		numbersToSort[7] = 7;
		numbersToSort[8] = 9;
		numbersToSort[9] = 8;
		numbersToSort[10] = 4;

		/*prints out unsorted array of numbers*/
		System.out.print("Before Sorting: ");
		for(int i = 0; i < numbersToSort.length; i++)
		{
			System.out.print(numbersToSort[i] + " ");
		}
		System.out.println();
		
		/*calls bubbleSort to sort the array*/
		bubbleSort(numbersToSort);
		
		/*prints out the sorted array*/
		System.out.print("After Sorting:  ");
		for(int i = 0; i < numbersToSort.length; i++)
		{
			System.out.print(numbersToSort[i] + " ");
		}
	}
	
	/* BubbleSort
	 * 
	 * Takes in a list of numbers as an argument and applies the bubble sort
	 * 
	 * returns the sorted array
	 */
	public static int[] bubbleSort(int[] arr){
		for(int i = arr.length - 1; i >= 1; i--){
			for(int j = 0; j < i; j++){
				/*swaps arr[j] and arr[j+1] if arr[j] is greated than [arrj+1]*/
				if(arr[j] > arr[j+1]) 
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
		    }
		}
		return arr;
	}
}
