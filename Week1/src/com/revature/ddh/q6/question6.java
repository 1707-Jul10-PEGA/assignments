package com.revature.ddh.q6;

import java.util.Scanner;

public class question6 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);  
		System.out.println("Enter a number: ");
		int x = scan.nextInt();
		
		scan.close();
		
		evenCheck(x);
		 
	}
	
	public static int evenCheck(int n) {
		n = n % 2;
		if (n == 1) {
			System.out.println("odd");
			return n;
		}
		if (n == 0) {
			System.out.println("even");
			return n;
		}
		return (evenCheck(n));
		
		
	}
}
