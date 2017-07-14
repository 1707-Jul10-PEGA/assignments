package com.dv.q19;

import java.util.*;

public class Driver {

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

	public static void removePrimes(List<Integer> origList) {
		List<Integer> tempList = origList;
		
		for(int i = 0; i<tempList.size(); i++) {
			if(isPrime(tempList.get(i))) {
				tempList.remove(i);
			}
		}

	}

	public static void addAllOdd(List<Integer> origList) {
		int result = 0;

		for(int i : origList) {
			if(i%2 != 0) {
				result += i;
			}
		}
		
		System.out.println("All odd numbers added: " + result);
	}

	public static void addAllEven(List<Integer> origList) {
		int result = 0;
	
		for(int i : origList) {
			if(i%2 == 0) {
				result += i;
			}
		}
		
		System.out.println("All even numbers added: " + result);
	}

	public static void populateList(List<Integer> origList) {
		List<Integer> tempList = origList;

		for(int i=0; i<10; i++) {
			tempList.add(i, i+1);
		}
	}

	public static void main(String[] args) {
	
		List<Integer> origList = new ArrayList<Integer>();
		populateList(origList);
		
		// print array list
		System.out.println("Displaying the original array list: ");
		System.out.println(origList);
		
		// add all even elements
		System.out.println("\nAdding all even elements: ");
		addAllEven(origList);

		// add all even elements
		System.out.println("\nAdding all odd elements: ");
		addAllOdd(origList);
		
		// remove prime numbers and print out the array list again
		System.out.println("\nNew list without prime elements: ");
		removePrimes(origList);
		System.out.println(origList);
	}

}
