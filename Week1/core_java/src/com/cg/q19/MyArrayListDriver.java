package com.cg.q19;

public class MyArrayListDriver {
	public static void main(String[] args) {
		MyArrayList myArray = new MyArrayList();

		//Create an array with the numbers 1 to 10
		myArray.createArrayList(10);
		
		//Add even and odd numbers
		myArray.sumEvenOdd();
		
		//Display results to console
		System.out.println("Array list: \n" + myArray.getMyArrayList());
		System.out.println("The sum of the even numbers is " + myArray.getEven());
		System.out.println("The sum of the odd numbers is " + myArray.getOdd());

		myArray.removePrimes();
		System.out.println("Array list without primes: \n" + myArray.getMyArrayList());

	}
}
