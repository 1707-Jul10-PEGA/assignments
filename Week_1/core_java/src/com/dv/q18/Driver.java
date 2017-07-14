package com.dv.q18;

import java.util.*;

public class Driver {

	public static void hasUppercase(boolean check) {
		if(check) {
			System.out.println("Your string contains an uppercase letter!");
		}
		
		else {
			System.out.println("Your string does not contain any uppercase letters");
		}
	}

	public static void main(String[] args) {
	
		boolean check = false;
		String str = "";
		Strings strs = new Strings();
		Scanner read = new Scanner(System.in);
		
		// check for upper case letters
		System.out.println("Enter a word: ");
		check = strs.containsUppercase(read.nextLine());
		hasUppercase(check);
		
		// capitalizes lower case letters
		System.out.println("Enter a word: ");
		str = strs.lowercaseToUppercase(read.nextLine());
		System.out.println("Capitalizing all lowercase letters to : " + str);
		
		// adds 10 to input string
		System.out.println("Enter a number: ");
		strs.addTenTo(read.nextLine());
		
		read.close();
	}

}
