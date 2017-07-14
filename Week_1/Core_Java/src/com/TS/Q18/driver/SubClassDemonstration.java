/*
 * Tae Song
 * Question 18 - SubClassDemonstration class
 */
package com.TS.Q18.driver;

/*
 * Implements the abstract methods from the SuperClassDemonstrat abstract class
 */
public class SubClassDemonstration extends SuperClassDemonstration {

	/*Checks to see if the string, given as the argument, contains an uppercase*/
	@Override
	public boolean checkUppercase(String s) {
		// TODO Auto-generated method stub
		for(int i = 0; i < s.length(); i++)
		{
			if (Character.isUpperCase(s.charAt(i)))
			{ return true; }
		}
		return false;
	}

	/*The given string's characters are uppercased*/
	@Override
	public String toUppercase(String s) {
		// TODO Auto-generated method stub
		return s.toUpperCase();
	}

	/*Converts the string into an integer, and adds 10*/
	@Override
	public int printAsNumber(String s) {
		// TODO Auto-generated method stub
		int nowNumber = Integer.parseInt(s);
		nowNumber += 10;
		return nowNumber;
	}

	public SubClassDemonstration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
