package com.cg.q1;

public class BubbleSort {
	public static void main(String[] args){ 
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length-1; j++){
				//System.out.println(arr[j]);
				if(arr[j+1] < arr[j]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
		}
		
		for( int k:arr) {
			System.out.println(k);
		}
	}
}
