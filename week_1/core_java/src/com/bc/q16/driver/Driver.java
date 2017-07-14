package com.bc.q16.driver;

public class Driver {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("\"" + args[i] + "\"" + " has " + args[i].length() + " characters");
		}
	}
}
