package com.cg.q9;

import java.util.ArrayList;

public class Primes {
	public static int[] createArray(int n) {
		int[] intArray = new int[n];
		for (int i = 1; i <= n; i++) {
			intArray[i - 1] = i;
		}

		return intArray;
	}

	public static void printPrimes(int[] arr) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int gcf = 0;

		for (int i : arr) {
			
			// Base case
			if (i == 2) {
				primes.add(i);
			} 
			
			else if(i > 2){
				// By definition  
				if (!com.cg.q6.Even.even(i)) {
					for (int k : primes) {
						gcf = greatestCommonFactor(k, i);
						if (gcf > 1) {
							break;
						}
					}
					if (gcf == 1) {
						primes.add(i);
					}
				}
			}
		}

		for (int i : primes) {
			System.out.println(i);
		}

	}

	public static int greatestCommonFactor(int x, int y) {
		do {
			if (x > y) {
				x = x - y;
			} else {
				y = y - x;
			}
		} while (x != y);

		return x;
	}

	public static void main(String[] args) {
		printPrimes(createArray(100000));
	}

}
