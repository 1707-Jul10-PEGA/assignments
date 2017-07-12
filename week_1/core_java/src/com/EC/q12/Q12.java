package com.EC.q12;


public class Q12 {

	public static void main(String[] args) {
		
		int [] arr = new int[100];
		fillArray(arr);
		printEvenNumbers(arr);

	}
	
	public static void fillArray(int[] arr){
		for(int i=1;i<=100;i++){
			arr[i-1]=i;
		}
	}
	
	public static void printEvenNumbers(int [] arr){
		for(int i : arr){
			if(isEven(i)){
				System.out.print(i + " ");
			}
		}
	}
	
	public static boolean isEven(int x){
		if(x%2==0){
			return true;
		}
		else{
			return false;
		}
	}

}
