package com.rb.q19.driver;

import java.util.ArrayList;

public class ArrayListTen {

	public static void main(String[] args) {
		
		// create Integer ArrayList and add 1-10
		ArrayList<Integer> ten = new ArrayList<Integer>();
		
		for(int i = 1; i<=10; i++){
			ten.add(i);
		}
		
		// output ArrayList of 1-10
		System.out.println(ten);
		
		
		// create int value to store sum
		int evenSum = 0;
		
		// starting from 2, add each even number to sum
		for(int i = 1; i < 10; i += 2){
			evenSum += ten.get(i);
		}
		// print sum
		System.out.println("sum of even numbers: " + evenSum);
		
		
		// create int value to store sum
		int oddSum = 0;
		
		// starting from 1, add each odd number to sum
		for(int i = 0; i < 10; i += 2){
			oddSum += ten.get(i);
		}
		// print sum
		System.out.println("sum of odd numbers: " + oddSum);
		
		// run for every number in ArrayList
		for(int i = 1; i < ten.size(); i++){
			
			// get the number
			int num = ten.get(i);
			// set check to true
			boolean prime = true;
			
			// for a number between 2 and the number,
			// run this loop
			for(int j = 2; j < num; j++){
				// if it's been shown that the number isn't
				// prime, break from this loop
				if(!prime){
					break;
				}
				
				// if a previous number divides evenly into
				// the one you're looking at, set check to
				// false
				if(num%j == 0){
					prime = false;
				}
			}
			
			// if check flag is still true, remove the current
			// value from the ArrayList and then reduce the index
			// to check next by one, to because the next number to
			// check is in the current index
			if(prime){
				ten.remove(i);
				i--;
			}
		}
		
		// print ArrayList of non-prime numbers
		System.out.println(ten);
	}
}