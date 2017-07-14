package com.md.q12;

import java.util.Arrays;

/**
 * Write a program to store numbers from 1 to 100
 * in an array. Print out all even prime numbers
 * from the array. Use the enhaced for loop for
 * printing out the numbers
 * @author Martin Delira
 *
 */
public class EvenNumbers {
public static void main(String[] args) {
	
	int[] myarray = new int[100];
	
	for(int i = 0; i<100;i++) {
		myarray[i] = i+1;
	}
	
	System.out.println("Original Array:"+ Arrays.toString(myarray));
	
	for(int n:myarray) {
		if(n%2 == 0) {
			System.out.print(""+n+", ");
		}
	}
	
}



}
