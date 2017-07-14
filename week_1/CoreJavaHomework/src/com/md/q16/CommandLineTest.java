package com.md.q16;


/**
 * Write a program that displays the number of characters
 * for a string input. The string should be entered as a
 * command line argument using (String[] args)
 * 
 * USE: java -classpath . com.md.q16.CommandLineTest [argument]
 * 
 * @author Martin Delira
 *
 */
public class CommandLineTest {
	public static void main(String[] args) {
		
		
		String word = args[0];
		int wordLength = word.length();
		System.out.println("Number of characters in " + word + " is "  + wordLength);
		
				
	}
}
