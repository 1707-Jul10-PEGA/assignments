package com.wh.q11;

/**
 * Q11. Write a program that would access two float-variables from a class that
 * exists in another package. Note, you will need to create two packages to
 * demonstrate the solution.
 * 
 * @author Wei Huang
 *
 */
public class Q11 {
	public static void main(String[] args) {
		int x = com.wh.q11b.Q11.x;
		int y = com.wh.q11b.Q11.y;
		System.out.println("x: " + x + ", y: " + y);

	}
}
