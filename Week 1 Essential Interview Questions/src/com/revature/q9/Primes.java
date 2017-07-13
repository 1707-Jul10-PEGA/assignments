package com.revature.q9;

import java.util.ArrayList;

public class Primes {
public static void main(String[] args) {
		ArrayList<Integer> myAL = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int x = 0; x < 100; x++){
			myAL.add(x + 1);
		}
		System.out.println("Here's the ArrayList without removing non-primes: \n");
		System.out.println(myAL);
		
		
		for(int x = 0; x < myAL.size(); x++){
			if(isPrime(x)){
				primes.add(x);
			}
		}
		System.out.println("Here are all of the primes in the old ArrayList: \n" + primes);
	}
	public static boolean isPrime(int x){
		if(x == 0 || x == 1 || x%2 == 0){
			
			return false;
		}
		else if(x == 2){
			return true;
		}
		else{
			for(int count = 2; count < x; count++){
				if(x%count == 0){
					return false;
				}
			}
			return true;
		}
	}
}
