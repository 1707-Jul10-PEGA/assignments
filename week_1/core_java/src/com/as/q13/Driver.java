package com.as.q13;

public class Driver {

	public static void main(String[] args){
		//the number of lines ot print
		int lines = 4;
		//prints out a triangle
		printTriangle(lines);
	}
	
	/*
	 * Prints out a triangle of 1s, 0s, and white spaces to the console
	 * with number of lines equal to the passed parameter
	 */
	private static void printTriangle(int l){
		//string representing the line to be printed
		String line = "";
		for (int i = 0; i < l; i++) {
			if (i == 0) {
				line += "0";
			} else {
				
			}
			System.out.println(line);
		}
	}
}
