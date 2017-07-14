package com.MS.Q18.driver;

public abstract class Inheritance {
	
	abstract boolean upperCase(String s);
	abstract String toUpper(String s);
	abstract int plusToInt(String s);

	/*
	 * The abstract superclass provides 3 "skeleton" methods for
	 * the subclass to implement. The main function simply sets
	 * up the needed variables and prints the results to the console.
	 */
	
	public static void main(String[] args) {
		

		Child example = new Child();
		String uppercase = "smashing";
		String testint = "90";
		
		System.out.println(example.upperCase(uppercase));
		System.out.println(example.toUpper(uppercase));
		System.out.println(example.plusToInt(testint));
	}
	
	

}
