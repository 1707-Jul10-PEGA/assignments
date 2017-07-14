package com.hy.q1.driver;

public class Question1 {
	public Question1(){
		
		
	}
	
	public int[] bubbleSort(int[] arr){
		int temp = 0;
		for(int i = arr.length -1; i >= 0; i--){
			for(int j = 0; j < i; j++){
				if(arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
		}
		return arr;
	}
	
	public static final void main(String[] args){
		int array[] = {1,0,5,6,3,2,3,7,9,8,4};
		Question1 q1 = new Question1();
		int[] res = q1.bubbleSort(array);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
	}
	
}
