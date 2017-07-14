package com.revature.ddh.question10;

import java.util.Scanner;

public class Minimum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int x = scan.nextInt();
		System.out.println("Enter another number: ");
		int y = scan.nextInt();
		
		int minVal = (y < x) ? y : x;
		scan.close();
		System.out.println(minVal);
	}

}
