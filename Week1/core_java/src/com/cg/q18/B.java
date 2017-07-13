package com.cg.q18;

import java.util.ArrayList;

public class B extends A {

	@Override
	public boolean checkForUppercase(String str) {
		int ascii;

		//Iterate thru the string
		for (int i = 0; i < str.length(); i++) {
			ascii = str.charAt(i);
			// As soon as it encounters an upper case character return
			if (ascii > 64 && ascii < 91) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String convertToUppercase(String str) {
		int ascii;
		char temp;

		//Iterate thru the string
		for (int i = 0; i < str.length(); i++) {
			ascii = str.charAt(i);

			/*
			 * If there's a lowercase character replace the character the upper
			 * case at the location of the string
			 */
			if (ascii > 96 && ascii < 123) {
				temp = (char) (ascii - 32);
				str = str.replace(str.charAt(i), temp);
			}
		}
		return str;
	}

	@Override
	public void convertStringToInt(String str) {
		ArrayList<Character> c = new ArrayList<Character>();
		int ascii;

		//Iterate thru the string
		for (int i = 0; i < str.length(); i++) {

			ascii = str.charAt(i);

			// Check for negative number
			if (ascii == 45 && c.size() == 0) {
				c.add((char) ascii);
			}
			// Check that it contains a number from 0 to 9
			else if (ascii > 47 && ascii < 58) {
				c.add((char) ascii);
			}
		}
		// Create an empty string
		String string = "";

		//Add each number or minus sign to the string
		for (Character i : c) {
			string += i;
		}

		//As long as the string is not empty print out the integer found
		if (!string.isEmpty()) {
			System.out.println(Integer.valueOf(string)+10);
		} else {
			System.out.println("String doesn't contain an integer.");
		}

	}

}
