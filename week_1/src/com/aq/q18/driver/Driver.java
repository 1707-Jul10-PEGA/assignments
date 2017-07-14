package com.aq.q18.driver;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		ConcreteClass myClass = new ConcreteClass();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a String to Test To upperCaseCheck");
		String teststring1 = scan.nextLine();
		System.out.println(myClass.upperCaseCheck(teststring1));
		
		System.out.println("Enter a String to Test To Upper");
		String teststring2 = scan.nextLine();
		System.out.println(myClass.toUpper(teststring2));
		
		System.out.println("Enter a String to Test addTen");
		String teststring3 = scan.nextLine();
		myClass.addTen(teststring3);
		scan.close();
	}
}
