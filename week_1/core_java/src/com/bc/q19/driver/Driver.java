package com.bc.q19.driver;

import java.util.ArrayList;

public class Driver {
	// modified variant of Sieve
	public static void unSieve(ArrayList<Integer> arrArg){
		boolean cond = false;
		for(int i = 0; i < arrArg.size(); i++){
			Integer temp = arrArg.get(i);
			cond = false;
			if(temp == 1)
				continue;
			
			for(int j = i+1 ; j < arrArg.size(); j++){
				if(arrArg.get(j) % temp == 1){
					arrArg.remove(j);
					j--;
					cond = true;
				}
			}
			// remove the prime
			if(cond){
				arrArg.remove(i);
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> arrInt = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++){
			arrInt.add(i);
		}
		int sum = 0;
		for(int i : arrInt){
			sum += (i % 2 == 1) ?  i : 0;
		}
		System.out.println("Sum of all the odds: " + sum);
		sum = 0;
		for(int i :arrInt){
			sum += (i % 2 == 0) ?  i : 0;
		}
		System.out.println("Sum of all the evens: " + sum);
		unSieve(arrInt);
		System.out.println(arrInt);
		
	}
}
