package com.rb.q9.driver;

import java.util.ArrayList;

public class PrimesUnder100 {
	
	public static void main(String args[]){
		
		ArrayList<Integer> hundred = new ArrayList<Integer>();
		
		for(int i = 1; i <=100; i++){
			hundred.add(i);
		}
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		primes.add(2);
		System.out.println(2);
		
		for(int checkPrime : hundred){
			boolean isPrime = true;
			if(checkPrime == 1){
				continue;
			}
			for(int checkWith : primes){
				if(checkPrime % checkWith == 0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime){
				primes.add(checkPrime);
				System.out.println(checkPrime);
			}
		}
	}
}
