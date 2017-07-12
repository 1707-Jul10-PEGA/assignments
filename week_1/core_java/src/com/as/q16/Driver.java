package com.as.q16;

public class Driver {
	public static void main(String[] args) {
		if (args.length > 0) {
			String s = args[0];
			System.out.println("The number of characters in " + s + " is " + s.length());
		} else {
			System.out.println("No string entered.");
		}
	}
}
