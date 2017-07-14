package com.md.q9;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Martin Delira
 *
 * Crate an ArrayList which stores numbers form 1 to 100 and prints out
 * all the prime numbers to the console
 */

public class PrimeNumbers {

	public static void main(String[] args) {

		ArrayList<Integer> numList = new ArrayList<Integer>();

		for (int i = 0; i <= 100; i++) {
			numList.add(i);
		}

		numList = sieve(numList);
		System.out.println("\nResulting ArrayList: \n" + numList);

	}

	/**
	 * This method follows the Sieve Of Eratosthenes algorithm
	 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 * 
	 * Input: an integer n > 1.
	 * 
	 * Let A be an array of int values, indexed by integers 2 to n
	 * 
	 * 		for i = 2, 3, 4, ..., not exceeding square root of n: for j = i^2, i^2+i,
	 * 			i^2+2i, i^2+3i, ..., not exceeding n: A[j] := 0.
	 * 
	 * Output: all i such that A[i] != 0.
	 * 
	 * @param numberList
	 * @return numberList
	 */
	public static ArrayList<Integer> sieve(ArrayList<Integer> numberList) {

		numberList.set(1, 0);//1 is not prime by definition
		int i = 2;
		
		int n = numberList.size();

		int t = 0;// multiplier

		while (i < ((int) Math.sqrt(n))) {
			for (int j = (((int)Math.pow(i,2)) + (t*i)); j < n ; j = (( (int)Math.pow(i, 2)  ) + (++t * i))) {
				//System.out.println("Took out " +(j));
				numberList.set(j, 0);
			}
			i++;	
			t=0;
		}
		numberList.removeAll(Arrays.asList(0));//removes all 0
		return numberList;
	}
	
	public static boolean isPrime(int n) {
		//have a number list at least twice as big as the number to be tested
		ArrayList<Integer> numList = generateNumbers(n*n);
		ArrayList<Integer> primeList = sieve(numList);
		
		if(primeList.contains(n)) {
			return true;
		}
		return false;
	}
	
	/*Generates a list of numbers from 0 to the range*/
	public static ArrayList<Integer> generateNumbers(int range){
		ArrayList<Integer> numList = new ArrayList<Integer>();

		for (int i = 0; i <= range; i++) {
			numList.add(i);
		}
		return numList;
	}
}
