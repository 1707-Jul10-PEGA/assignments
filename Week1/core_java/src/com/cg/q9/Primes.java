package com.cg.q9;

import java.util.ArrayList;

import com.cg.q6.Even;

public class Primes {
	public static void main(String[] args) {
		Primes p = new Primes();
		
		//Create array, if array contain primes and print it
		p.printPrimes(p.checkForPrimes(p.createArray(100)));
	}

	// Creates an Array list of size n and add numbers  1...n
	public ArrayList<Integer> createArray(int n) {
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			intArray.add(i);
		}

		return intArray;
	}

	//Check an array and return an array list of primes found
	public ArrayList<Integer> checkForPrimes(ArrayList<Integer> arr) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Even e = new Even();
		int gcf = 0;

		for (int i : arr) {

			// Base case
			if (i == 2) {
				primes.add(i);
			}

			else if (i > 2) {
				// By definition 2 is the only even number
				if (!e.even(i)) {
					for (int k : primes) {
						gcf = greatestCommonFactor(k, i);
						if (gcf > 1) {
							break;
						}
					}
					// i is a prime if it's only divisible by one and itself
					if (gcf == 1) {
						primes.add(i);
					}
				}
			}
		}
		return primes;
	}

	// Print primes located in array list
	public void printPrimes(ArrayList<Integer> primes) {

		for (int i : primes) {
			System.out.println(i);
		}

	}

	// Returns the greatest common factor of two numbers
	public int greatestCommonFactor(int x, int y) {
		do {
			if (x > y) {
				x = x - y;
			} else {
				y = y - x;
			}
		} while (x != y);

		return x;
	}

}
