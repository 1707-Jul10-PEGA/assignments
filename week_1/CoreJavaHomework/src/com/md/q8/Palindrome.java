package com.md.q8;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Write a program that store the following strings 
 * in an ArrayList and saves all of the palindromes
 * in another ArrayList
 */

public class Palindrome {
	public static void main(String[] args) {

		ArrayList<String> words = new ArrayList<String>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("bily");
		words.add("did");

		palindrome(words);

		System.out.println("List before palindrome filter: " + words);

		words = palindrome(words);

		System.out.println("List after palindrome filter: " + words);

	}

	public static ArrayList<String> palindrome(ArrayList<String> words) {
		ArrayList<String> palindrome = new ArrayList<String>();

		for (String s : words) {

			int length = s.length();

			// Even palindromes
			if (length % 2 == 1) {

				int head = 0;
				int tail = length - 1;

				//Goes from outside of word to the inside. Corresponding
				//indexes must have the same letter
				while (head != tail && (s.charAt(head) == s.charAt(tail))) {
					head++;
					tail--;
					
					if (head == tail) {
						palindrome.add(s);
					}
				}
			}
		}

		return palindrome;
	}

}
