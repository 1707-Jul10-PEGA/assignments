package com.rb.q10.driver;

import java.util.Scanner;

public class Minimum {
	
	public static void main(String args[]){
		// print instructions, create input stream, read user input
		System.out.print("Input integer: ");
		Scanner inStream = new Scanner(System.in);
		int n = inStream.nextInt();
		System.out.print("Input integer: ");
		int n2 = inStream.nextInt();
		inStream.close();
		
		// the ternary operator puts n into min if n is less than
		// n2, and puts n2 into min otherwise.
		int min = (n<n2) ? n : n2;
		
		// print out result
		System.out.println("The minimum value is " + min);
	}
}
