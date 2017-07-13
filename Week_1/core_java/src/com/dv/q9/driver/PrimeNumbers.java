package com.dv.q9.driver;

import java.util.*;

public class PrimeNumbers {

	public static boolean isPrime(int number) {
		int i = 0;
		int range = (number/2) + 1;		// grab range of numbers to check; +1 just to make sure
		
		// prime numbers are greater than 1
		if(number <= 1) {
			return false;
		}
		
		// 2 is the first prime
		if(number == 2) {
			return true;
		}
		
		// check if number is even
		if(number%2 == 0) {
			return false;
		}
		
		// 1 and 2 are already checked; start at 3
		for(i=3; i<range; i++) {
		
			// if the number is divisible by another number within the range, it is not a prime number
			if(number%i == 0) {
				return false;
			}	
		}
		
		return true;
	}

	public static void printPrimeNumbers(ArrayList<Integer> origList) {
		for(Integer i : origList) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public static ArrayList<Integer> initOrigList() {
		int number = 1;
		ArrayList<Integer> origList = new ArrayList<Integer>();
		
		while(number <= 100) {
			origList.add(number);
			number++;
		}
		
		return origList;
	}

	public static void main(String[] args) {
		ArrayList<Integer> origList = initOrigList();
		printPrimeNumbers(origList);
	}

}