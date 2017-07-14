package com.aq.q6.driver;

import java.util.Scanner;

public class EvenOrOdd {
	public static void main(String[] args) {
		System.out.println("This program determins if the entered number is even");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an integer");
		int i = scan.nextInt();
		System.out.println(evenOrOdd(i));
		scan.close();
	}
	
	private static boolean evenOrOdd(int n){
		return (n/2) * 2 == n;
	}
}
