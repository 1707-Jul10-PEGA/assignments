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
 * 3. Convert the input string to integer and add10, output the result to the
 * console.
 * 
 * Create an appropriate class having a main method to test the above setup.
 * 
 * @author Wei Huang
 *
 */

public abstract class Q18 {

    /**
     * Check for uppercase characters in a string, and return 'true' or 'false'
     * depending if any are found.
     * 
     * @param str
     *            - a String value.
     * @return true if uppercase character is found; false otherwise.
     */
    public abstract boolean hasUpperCase(String str);

    /**
     * Convert all of the lower case characters to uppercase in the input
     * string, and return the result.
     * 
     * @param str
     *            - a String value.
     * @return the String value but with all uppercase characters.
     */
    public abstract String toUpperCase(String str);

    /**
     * Convert the input string to integer and add10, output the result to the
     * console.
     * 
     * @param str
     *            - A String value.
     */
    public abstract void toIntAddTen(String str);
}
