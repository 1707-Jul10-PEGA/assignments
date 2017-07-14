package com.md.q19;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create an ArrayList and insert integers 1 through 10. Display
 * the ArrayList. Add all the even numbers up and display the result.
 * Add all the odd numbers up and display the result. Remove the
 * prime number from the ArrayList and print out the remaining ArrayList
 * @author Martin Delira
 *
 */
import com.md.q6.EvenOrOdd;
import com.md.q9.PrimeNumbers;


public class ArrayListOperations {

	public static void main(String[] args) {
					
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10 ; i++) {
			intList.add(i);
		}
		
		System.out.println("Current Array state: " + intList );
		addEvenOrOdd(intList, "even");
		addEvenOrOdd(intList, "odd");
		System.out.print("List after removing primes: " + removePrimes(intList));
		
	}
	
	public static void addEvenOrOdd(ArrayList<Integer> numList, String arg) {
		EvenOrOdd compare = new EvenOrOdd();
		
		int sum = 0;
		
		if(arg == "even") {
			for(int n : numList) {
				if(compare.isEven(n)) {
					sum+=n;
				}
			}
			
			System.out.println("Sum of even numbers is:" + sum);	
		}
		
		else if (arg == "odd") {
			for(int n : numList) {
				if(!compare.isEven(n)) {
					sum+=n;
				}
			}
			System.out.println("Sum of odd numbers is:" + sum);
		}
						
	}
	
	
	public static ArrayList<Integer> removePrimes(ArrayList<Integer> numList) {
		
		PrimeNumbers compare = new PrimeNumbers();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(Integer i: numList) {
			if(!compare.isPrime(i)) {
			result.add(i);
			}
		}
		return result;
	}	
}
