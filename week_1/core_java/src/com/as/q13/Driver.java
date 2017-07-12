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
		StringBuilder line = new StringBuilder("");
		for (int i = 0; i < l; i++) {
			//Initial line is a single 0
			if (i == 0) {
				line.append("0");
			} else {
				//if the character at the beginning of the string
				//is not equal to the character at the end of the string
				//append the beginning character to the end of the string
				if (line.charAt(0) != line.charAt(line.length() - 1)) {
					line.append(" " + line.charAt(0));
				} else {
					//if the beginning character matches the ending character
					//then insert the opposite character at the beginning
					if ('0' == line.charAt(0)){
						line.insert(0, "1 ");
					} else {
						line.insert(0, "0 ");
					}
				}
			}
			//print the line
			System.out.println(line);
		}
	}
}
