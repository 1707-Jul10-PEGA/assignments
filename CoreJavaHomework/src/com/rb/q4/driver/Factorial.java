package com.rb.q4.driver;

import java.util.Scanner;

public class Factorial {
    
	public static void main(String args[]){
		// print instructions, create input stream, read user input
		System.out.print("Input integer: ");
		Scanner inStream = new Scanner(System.in);
		int n = inStream.nextInt();
		inStream.close();
		
		// calculate n!
		int output = recurse(n);
		
		// output result
		System.out.print(n + " factorial = " + output);
	}
	
	private static int recurse(int n){
		// end case for recursion
		if(n <= 1){
			return 1;
		// n! = n * (n-1)!, so calculate (n-1)! and multiply by n
		}else{
			return n * recurse(n-1);
		}
	}
}
