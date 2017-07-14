/*
 * Tae Song
 * Question 11
 */
package com.TS.Q11.driver;

import com.TS.Q11tester.driver.FloatStore;

public class Main {
	public static void main(String[] args) {
		/*Instantiates a new FloatStore object, the class is stored in com.TS.Q11tester.driver*/
		FloatStore Q11 = new FloatStore();
		
		/*accesses the two float-variables*/
		Q11.floatStoreX = 1.1f;
		Q11.floatStoreY = 2.2f;
		
		Q11.setFloatStoreX(3.3f);
		
		/*prints out float-variables to check*/
		System.out.println("First Float: " + Q11.getFloatStoreX());
		System.out.println("Second Float: " + Q11.getFloatStoreY());
	}
}
