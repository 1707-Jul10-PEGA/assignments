package com.wh.q15;

/**
 * Q15. Write a program that defines an interface having the following methods:
 * addition, subtraction multiplication, and division. Create a class that
 * implements this interface and provides appropriate functionality to carry out
 * the required operations. Hard code two operands in a test class having a main
 * method that calls the implementing class.
 * 
 * @author Wei Huang
 *
 */
public interface Q15 {

    /**
     * @param x
     *            - a value
     * @param y
     *            - another value
     * @return the sum of the two values
     */
    public int addition(int x, int y);

    /**
     * @param x
     *            - a value
     * @param y
     *            - another value
     * @return the difference of the two values
     */
    public int subtraction(int x, int y);

    /**
     * @param x
     *            - a value
     * @param y
     *            - another value
     * @return the product of the two values
     */
    public int multiplication(int x, int y);

    /**
     * @param x
     *            - the dividend
     * @param y
     *            - the divisor
     * @return the quotient of the two values
     */
    public int division(int x, int y);
}
