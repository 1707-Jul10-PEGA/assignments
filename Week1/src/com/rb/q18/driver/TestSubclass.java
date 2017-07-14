package com.rb.q18.driver;

import java.util.Scanner;

public class TestSubclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcreteSubclass c = new ConcreteSubclass();
		
		System.out.print("Input string: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		if(c.checkUpper(str)){
			System.out.println("Input has at least one capital letter.");
		}else{
			System.out.println("Input is all lowercase");
		}
		
		System.out.print("\nInput a new string: ");
		
		str = scan.nextLine();
		
		str = c.makeUpper(str);
		
		System.out.println("String in all uppercase:\n" + str);
		
		System.out.print("\nInput integer: ");
		
		str = scan.nextLine();
		
		c.consolePrint(str);
		
		scan.close();
	}

}
