package com.rb.q18.driver;

import java.util.Scanner;

public class TestSubclass {

	public static void main(String[] args) {
		// initialize concrete subclass of interface
		ConcreteSubclass c = new ConcreteSubclass();
		
		// print out input request, then create scanner to read in
		// and store string to str variable
		System.out.print("Input string: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		// call c.checkUpper with input string and confirm with output
		if(c.checkUpper(str)){
			System.out.println("Input has at least one capital letter.");
		}else{
			System.out.println("Input is all lowercase");
		}
		
		// request input, store into str variable
		System.out.print("\nInput a new string: ");
		
		str = scan.nextLine();
		
		// call c.makeUpper and confirm
		str = c.makeUpper(str);
		
		System.out.println("String in all uppercase:\n" + str);
		
		// request integer input, store in str
		System.out.print("\nInput integer: ");
		
		str = scan.nextLine();
		
		// call c.consolePrint to convert string to integer, then add ten
		c.consolePrint(str);
		
		// close scanner
		scan.close();
	}
}