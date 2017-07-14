package com.wh.q18;

/**
 * Q18. Write a program having a concrete subclass that inherits three abstract
 * methods from a superclass. Provide the following three implementations in the
 * subclass corresponding to the abstract methods in the superclass:
 * 
 * 1. Check for uppercase characters in a string, and return 'true' or 'false'
 * depending if any are found.
 * 
 * 2. Convert all of the lower case characters to uppercase in the input string,
 * and return the result.
 * 
 * 3. Conver the input string to integer and add10, output the result to the
 * console.
 * 
 * Create an appropriate class having a main method to test the above setup.
 * 
 * @author Wei Huang
 *
 */

public abstract class Q18 {

	/**
	 * @param str
	 * @return
	 */
	public abstract boolean hasUpperCase(String str);

	/**
	 * @param str
	 * @return
	 */
	public abstract String toUpperCase(String str);

	/**
	 * @param str
	 */
	public abstract void toIntAddTen(String str);
}
