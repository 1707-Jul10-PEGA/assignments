package com.rb.q2.driver;

public class Fibbonacci {
	
	
	public static void main(String args[]){
		// initialize the first two Fibbonacci numbers
		int n = 0;
		int n2 = 1;
		
		// print the first number, without space or comma
		System.out.print(n);
		for(int i = 1; i < 25; i++){
			// calculate second through 25th number, printing comma and space before each
			int temp = n + n2;
			n = n2;
			n2 = temp;
			System.out.print(", " + n);
		}
	}
}
