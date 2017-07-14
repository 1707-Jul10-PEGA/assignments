package com.aq.q19.driver;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);
		
		System.out.println(numbers);

		
		int oddSum = 0;
		int evenSum = 0;
		for (Integer i:numbers) {
			if (i%2 == 0) {evenSum += i;}
			else {oddSum += i;}
		}
		
		System.out.println("Even Sum: " + evenSum);
		System.out.println("Odd Sum " + oddSum);
		
		int nonPrimeSum = 0;
		for (int i = 0; i < numbers.size(); i++ ) {
			if (primality(i)) { numbers.remove(i);}
			else {nonPrimeSum += i;}
		}
		System.out.println(nonPrimeSum);
		System.out.println(numbers);
	}
	
	public static boolean primality(Integer n) {
		if (n == 0) {return false;}
		if (n == 1) {return false;}
		if (n == 2) {return true;}
		for (Double i = 2.0; i <= n/2 ; i++) {
			if (Math.floor(n/i) == n/i) { return false;}
		}
		return true;
	}
}
