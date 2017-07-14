package com.cg.q12;

public class EvenNumbers {
	
	public static void main(String[] args) {
		EvenNumbers e = new EvenNumbers();
		
		//Test the create array method and print method
		e.printEvenNumber(e.createArray(100));
		
	}
	
	//Creates an array from 1 to n
	public int [] createArray(int n){
		int [] arr = new int [n] ;
		
		for(int i = 1; i <= n; i++){
			arr[i-1] = i;
		}
		
		return arr;
	}
	
	/* Iterates thru the array
	 * prints out the even number
	 * using class even from problems number 6
	 */
	public void printEvenNumber(int [] arr){
		for(int i:arr){
			if(com.cg.q6.Even.even(i)){
				System.out.println(i);
			}
		}
	}
}
