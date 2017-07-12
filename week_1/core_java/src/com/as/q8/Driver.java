package com.as.q8;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args){
		//list to store all of the strings
		ArrayList<String> strings = new ArrayList<String>();
		//list to store all of the strings that are palindromes
		ArrayList<String> palindromes = new ArrayList<String>();
		//populate the lists
		storeArrayLists(strings, palindromes);
		//print out all of the strings
		System.out.println(strings);
		//print out only the palindromes
		System.out.println(palindromes);
	}
	
	/*
	 * Stores all of the strings in the first parameter and only palindromes
	 * in the second parameter
	 */
	private static void storeArrayLists(ArrayList<String> l, ArrayList<String> p) {
		//add all of the strings to the list
		l.add("karan");
		l.add("madam");
		l.add("tom");
		l.add("civic");
		l.add("radar");
		l.add("sexes");
		l.add("jimmy");
		l.add("kayak");
		l.add("john");
		l.add("refer");
		l.add("billy");
		l.add("did");
		//check for strings that are palindromes
		//store them in the second arraylist 
		for (String s: l){
			StringBuilder str = new StringBuilder(s);
			str.reverse();
			if (s.equals(str.toString())) {
				p.add(s);
			}
		}
	}
	
}
