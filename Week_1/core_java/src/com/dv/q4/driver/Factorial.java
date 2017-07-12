package com.dv.q4.driver;

import java.util.Scanner;

public class Factorial {
	
	public static void factorial(int N) {
		int i = 0, res = 1;
		
		for(i=1; i<=N; i++){
			res = res*i;
		}
		
		System.out.println(N + "! = " + res);
		
	}
	
	public static void getUserInput() {
		int N = 0;
		Scanner read = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		N = read.nextInt();
		factorial(N);
		
	}

	public static void main(String[] args) {
		getUserInput();
	}
}
