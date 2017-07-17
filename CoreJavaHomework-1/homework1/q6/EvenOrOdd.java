package q6;

import java.util.Scanner;

/*
 * Q6: Write a program to determine if an integer is even without using the
 * modulus operator(%)
 */

public class EvenOrOdd {

	public static void main(String[] args) {
		System.out.print("Please Enter a Number: ");
		Scanner n = new Scanner(System.in);
		int number = n.nextInt();
		
		int half = number/2;
		if((half * 2) == number) {
			System.out.println(number + " is Even.");
		} else {
			System.out.println(number + " is Odd.");
		}
		
	}
	
}
