package com.wh.q16;

/**
 * Q16. Write a program to display the number of characters for a string input.
 * The string should be entered as a command line argument using (String[]args).
 * 
 * @author Wei Huang
 *
 */
public class Q16 {

    public static void main(String[] args) {
	if (args.length != 0) {
	    System.out.println(args[0].length());
	}
    }

}
