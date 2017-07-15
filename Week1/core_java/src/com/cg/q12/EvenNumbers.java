package com.cg.q12;

import com.cg.q6.Even;

public class EvenNumbers {
	
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
	 * using a method  from class even 
	 * from problems number 6
	 */
	public void printEvenNumber(int [] arr){
		Even e = new Even();
		for(int i:arr){
			if(e.even(i)){
				System.out.println(i);
			}
		}
	}
}
