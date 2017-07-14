package com.MS.Q11.driver;
import com.MS.Q11.floats.*;
public class Main {

	/*
	 * The main function includes an import from a different package (in this case,
	 * the Q11.floats package). It draws the instantiated variables from the other
	 * package.
	 */
	public static void main(String[] args) {
		
		Floatclass example = new Floatclass();
		System.out.println("Float a contains: " + example.getA());
		System.out.println("Float b contains: " + example.getB());
	}

}
