package com.revature.ddh.q4;

import java.util.Scanner;

import com.revature.ddh.q4.Factorial;
public class question4 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int x = scan.nextInt();
		scan.close();
		Factorial n = new Factorial();
		
		
		System.out.println(n.factorial(x));
	}
}
