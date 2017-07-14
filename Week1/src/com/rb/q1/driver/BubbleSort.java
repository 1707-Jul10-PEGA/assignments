package com.rb.q1.driver;

public class BubbleSort {
	
	
	public static void main(String args[]){
		int[] toSort = {1,0,5,6,3,2,3,7,9,8,4};
		
		// print initial array state
		System.out.print(toSort[0]);
		for(int i = 1; i < toSort.length; i++){
			System.out.print(", " + toSort[i]);
		}
		// move to new line
		System.out.println("\n");
		
		boolean done = true;
		do{
			// each pass, swap adjacent elements if needed
			// if elements are swapped, done = false so the
			// next pass will execute. Otherwise, the loop
			// will end
			done = true;
			for(int i = 1; i < toSort.length; i++){
				if(toSort[i-1] > toSort[i]){
					int temp = toSort[i];
					toSort[i] = toSort[i-1];
					toSort[i-1] = temp;
					done = false;
				}
			}
		}while(!done);
		
		
		// Print out the full array
		System.out.print(toSort[0]);
		for(int i = 1; i < toSort.length; i++){
			System.out.print(", " + toSort[i]);
		}
	}
}
