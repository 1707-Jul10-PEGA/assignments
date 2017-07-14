package com.md.q18;

import java.util.Scanner;

/**
 * Write a program having a concrete class that inherits three 
 * Abstract methods form a superclass. Provide the following thre
 * implementations in the subclass corresponding to the abstract 
 * methods in the superclass:
 * 
 * 1.Check for upper case characters in a string, and return true
 * or false depending if any are found.
 * 
 * 2.Convert all of the lower case characters to upper case
 * in the input string and return the result.
 * 
 * 3.Convert the input string to integer and add 10, 
 * output the result to the console.
 * 
 * Create an appropriate class having a main method to
 * test the above setup.
 * 
 * 
 * @author Martin Delira
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChildClass child = new ChildClass();
		
		System.out.print("Write a word to check if it contains any upper case character:  ");
		String word = sc.nextLine();
		System.out.println(child.checkUpperCase(word));
		
		System.out.print("Enter a word to turn into all upper case:  ");
		word = sc.nextLine();
		System.out.println(child.toUpperCase(word));
		
		System.out.print("Enter a number  ");
		word = sc.nextLine();
		System.out.println(child.stringToIntPlusTen(word));
		
	}
	
}
