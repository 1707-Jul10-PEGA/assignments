package com.jntm.q19.driver;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		//Init arraylist
		ArrayList<Integer> arr = new ArrayList<Integer>();

		// Fill the list
		for (int x = 0; x < 10; x++) {
			arr.add((x + 1));
		}

		// Display the list
		System.out.println(arr);

		// Add, then display, all evens
		int sum = 0;
		for (Integer x : arr) {
			if (x % 2 == 0) {
				sum += x;
			}
		}
		System.out.println(sum);

		// same for odds
		sum = 0;
		for (Integer x : arr) {
			if (x % 2 != 0) {
				sum += x;
			}
		}
		System.out.println(sum);

		// Remove primes aka 2,3,5,7
		arr.remove(6);
		arr.remove(4);
		arr.remove(2);
		arr.remove(1);

		System.out.println(arr);

	}

}
