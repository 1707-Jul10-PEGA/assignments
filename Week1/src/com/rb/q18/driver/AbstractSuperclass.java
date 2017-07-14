package com.rb.q18.driver;

public interface AbstractSuperclass {
	
	// define parameters and return values of the needed
	// functions. CheckUpper should return true if any
	// character is uppercase
	boolean checkUpper(String str);
	
	// make upper returns the string with all letters
	// uppercase
	String makeUpper(String str);
	
	// convert input string to an int, if possible.
	// if it is converted, add ten and print it to
	// the console.
	void consolePrint(String str);
	
}
