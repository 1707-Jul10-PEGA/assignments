package com.md.q13;

/**
 * Display the triangle on the console as follows using any type of loop. Do not
 * use simple group of print statements to acomplish this.
 * 
 * @author Martin Delira
 *
 */
public class TrianglePattern {

	public static void main(String[] args) {
		triangle(10);
	}

	public static void triangle(int depth) {
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < i; j++) {
				int print = (j % 2 == 0) ? 0 : 1;
				System.out.print(print);
			}
			System.out.println();
		}
	}

}
