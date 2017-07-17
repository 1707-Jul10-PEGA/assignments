package q4;

import java.util.*;

/*
 * Q4: Write a program to compute N factorial.
 */

public class Factorial {

	private static Scanner n;

	public static void main(String[] args) {
		System.out.print("Please Enter a Number: ");
		n = new Scanner(System.in);
		int number = n.nextInt();
		factorial(number);

	}

	public static void factorial(int n) {
		int x = 1;
		
		for(int i = 1; i <= n; i++) {
			x = x * i;
			
		}
		System.out.println("Factorial = " + x);
	}
	
	
}
