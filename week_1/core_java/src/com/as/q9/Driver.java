package com.as.q9;

import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		printPrimes(nums);
	}
	
	private static void printPrimes(ArrayList<Integer> l) {
		//add the numbers 1 - 100 to the ArrayList
		for (int i = 1; i < 101; i++) {
			l.add(i);
		}
		//print out the prime numbers from the ArrayList
		for (int i = 1; i < l.size(); i++){
			//check that the number is not even or 2
			if (l.get(i) % 2 == 1 || Math.abs(l.get(i)) == 2) {
				//2 is the only even prime number and as such gets a special case
				//all other prime numbers greater than 2 are odd
				if (l.get(i) > 2) {
					//flag to see if a mod operation returned a 0
					boolean mod0 = false;
					//perform modulus division on the prime number candidate 
					//using all odd integers greater than 3 less than the candidate
					for(int j = 3; j < l.get(i); j+=2) {
						if (l.get(i) % j == 0){
							mod0 = true;
						}
					}
					//if all modulus operations yielded a result greater than 0
					//then it is a prime number
					if (!mod0) {
						System.out.println(l.get(i));
					}
				} else {
					System.out.println(l.get(i));
				}
			}
		}
	}
}
