package com.bc.q9.driver;

import java.util.ArrayList;

public class Driver {
	
	// This is Sieve of Eratosthenes
	// remove any numbers that isn't prime
	public static void sieve(ArrayList<Integer> arrArg){
		for(int i = 0; i < arrArg.size(); i++){
			Integer temp = arrArg.get(i);
			for(int j = i+1 ; j < arrArg.size(); j++){
				if(arrArg.get(j) % temp == 0){
					arrArg.remove(j);
					j--;
				}
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		// autoboxing
		for(int i = 1; i <= 100; i++){
			numberList.add(i);
		}
		// one is not prime
		numberList.remove(0);
		sieve(numberList);
		for(Integer i: numberList){
			System.out.println(i);
		}
		
		
	}
}
