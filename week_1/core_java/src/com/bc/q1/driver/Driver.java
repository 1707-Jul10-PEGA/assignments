package com.bc.q1.driver;

public class Driver {

	public static void bubbleSort(int[] arr1){
		int x = 0;
		//each iteration of the outer for loop will put the highest number to the end
		for(int i = 0; i < arr1.length - 1; i++){
			// takes roughly O(n) operation to put the highest number toward the end.
			for(int j = 0; j < arr1.length - i - 1; j++){
				if(arr1[j] > arr1[j +1]){
					x = arr1[j];
					arr1[j] = arr1[j + 1];
					arr1[j + 1] = x;
				}
			}	
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] unsorted = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(unsorted);
		for(int i = 0; i < unsorted.length; i++){
			System.out.print(unsorted[i] + " ");
			
		}
		
	}

}
