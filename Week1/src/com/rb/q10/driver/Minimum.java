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
		
		int min = (n<n2) ? n : n2;
		
		System.out.println("The minimum value is " + min);
	}
}
