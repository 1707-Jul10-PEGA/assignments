package com.rb.q18.driver;

import java.util.Scanner;

public class ConcreteSubclass implements AbstractSuperclass {

	// default constructor
	public ConcreteSubclass(){
		super();
	}
	
	@Override
	public boolean checkUpper(String str) {
		
		// if one character is in the range of ASCII capital
		// letters, then return true. Otherwise, return false
		for(int i = 0; i<str.length(); i++){
			if(str.charAt(i) >=65 && str.charAt(i) <= 90){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String makeUpper(String str) {
		
		// makes every character an uppercase letter
		String newString = str.toUpperCase();
		return newString;
	}

	@Override
	public void consolePrint(String str) {
		// initialize an integer and a boolean
		// int will store data, boolean is a
		// flag to check if the later code should run
		int i = 0;
		boolean print = true;
		
		// try to read string into an integer. If you
		// can't, then set print flag to false, so
		// the program doesn't add to i and print.
		try (Scanner scan = new Scanner(str)){
			i = scan.nextInt();
		}catch(Exception e){
			System.out.println("No Integer");
			print = false;
		}
		
		// if an integer was read in, add ten to the
		// value and print it out
		if(print){
			i += 10;
			
			System.out.println(i);
		}
	}
}
