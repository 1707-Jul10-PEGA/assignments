package com.dv.q6.driver;

import java.util.Scanner;

public class EvenNumber {

	public static boolean isEven(int num) {
		int check = num/2;
		
		// takes advantage of the flooring done by integer division
		if(check*2 == num) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void getUserInput() {
		int num = 0;
		boolean evenNumber = false;
		Scanner read = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		num = read.nextInt();
		
		if(isEven(num)) {
			System.out.println(num + " is even!");
		} else {
			System.out.println(num + " is odd.");
		}
	}
	
	public static void main(String[] args) {
		getUserInput();
	}
}
