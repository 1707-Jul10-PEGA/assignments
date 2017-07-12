package com.rb.q6.driver;

import java.util.Scanner;

public class isEven {
	
	public static void main(String args[]){
		// print instructions, create input stream, read user input
		System.out.print("Input integer: ");
		Scanner inStream = new Scanner(System.in);
		int n = inStream.nextInt();
		inStream.close();
		
		//calculate n/2, java always truncates int at decimal
		// so for an odd number, n/2 + n/2 will equal n - 1
		int n2 = n/2 + n/2;
		
		// check if n = n2, if true, n is even. Otherwise, n is odd
		if(n==n2){
			System.out.println(n + " is even.");
		}else{
			System.out.println(n + " is odd.");
		}
	}
}
