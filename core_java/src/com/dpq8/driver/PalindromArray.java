package com.dpq8.driver;

import java.util.ArrayList;

public class PalindromArray {		//I didn't realize palindrome was misspelled until too late to easily change
	
	private ArrayList<String> strings;
	private ArrayList<String> palindromes;

	public PalindromArray() {
		strings = new ArrayList<String>();
		strings.add("karan");
		strings.add("madam");
		strings.add("tom");
		strings.add("civic");
		strings.add("radar");
		strings.add("sexes");
		strings.add("jimmy");
		strings.add("kayak");
		strings.add("john");
		strings.add("refer");
		strings.add("billy");
		strings.add("did");
		palindromes = new ArrayList<String>();
	}
	
	public ArrayList<String> getStrings() {
		return strings;
	}

	public void setStrings(ArrayList<String> strings) {
		this.strings = strings;
	}

	public ArrayList<String> getPalindromes() {
		return palindromes;
	}

	public void setPalindromes(ArrayList<String> palindromes) {
		this.palindromes = palindromes;
	}

	public void populate() {
		for (int x = 0; x < this.getStrings().size(); x++) {
			String atX = this.getStrings().get(x);
			String first = atX.substring(0, atX.length()/2);
			String last;
			if (atX.length() % 2 == 1) {
				last = atX.substring(atX.length() / 2 + 1);
			}
			else {
				last = atX.substring(atX.length() / 2);
			}
			StringBuilder sb = new StringBuilder(last);
			last = sb.reverse().toString();
			System.out.println(last);
			if (last.equals(first)) {
				this.getPalindromes().add(this.getStrings().get(x));
			}
		}
	}
	
	@Override
	public String toString() {
		return "Strings=" + strings + ", Palindromes=" + palindromes;
	}
	
	public static void main(String[] args) {
		PalindromArray pa = new PalindromArray();
		pa.populate();
		System.out.println(pa.toString());
	}
}
