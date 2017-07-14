package com.rb.q9.driver;

import java.util.ArrayList;

public class PrimesUnder100 {
	
	public static void main(String args[]){
		
		// create and populate the array list of integers 1-100
		ArrayList<Integer> hundred = new ArrayList<Integer>();
		
		for(int i = 1; i <=100; i++){
			hundred.add(i);
		}
		
		// create ArrayList of primes, add and print the first prime number
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		System.out.println(2);
		
		for(int checkPrime : hundred){
			boolean isPrime = true;
			// One is neither prime nor composite, so skip it
			if(checkPrime == 1){
				continue;
			}
			
			/* if the number can be divided by a prime number on the list,
			it is not prime. Thus, mark that it shouldn't be printed and
			break from the inner for loop. If it's a prime, add it to the
			list and print it */
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
