package com.cg.q12;

public class EvenNumbers {
	public static int [] createArray(int n){
		int [] arr = new int [n] ;
		
		for(int i = 1; i <= n; i++){
			arr[i-1] = i;
		}
		
		return arr;
	}
	public static void printEvenNumber(int [] arr){
		for(int i:arr){
			if(com.cg.q6.Even.even(i)){
				System.out.println(i);
			}
		}
	}
	public static void main(String[] args) {
		printEvenNumber(createArray(100));
		
	}
}
