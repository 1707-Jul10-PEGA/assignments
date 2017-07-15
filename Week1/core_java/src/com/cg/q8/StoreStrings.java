package com.cg.q8;

import java.util.ArrayList;

public class StoreStrings {

	// Variables
	private ArrayList<String> palidromes;
	private ArrayList<String> nonpalidromes;
	private ArrayList<String> strings;

	// Constructor
	public StoreStrings() {
		palidromes = new ArrayList<String>();
		nonpalidromes = new ArrayList<String>();
		strings = new ArrayList<String>();
	}

	// Create an array list with the provided strings
	public void createArrayList(String[] strings) {
		for (String i : strings) {
			this.strings.add(i);
		}

	}

	// Save string to their corresponding array
	public void checkStrings() {
		for (String i : strings) {
			boolean flag = true;

			for (int j = 0, k = i.length() - 1; j < i.length(); j++, k--) {
				if (i.charAt(j) != i.charAt(k)) {
					flag = false;
					break;
				}
			}

			if (flag) {
				palidromes.add(i);
			} else {
				nonpalidromes.add(i);
			}
		}
	}

	// Display the strings pass by user
	public void printStrings() {
		System.out.print("Original: ");
		System.out.println(palidromes);
	}

	// Display Palidromes
	public void printPalidromes() {
		System.out.print("Palidromes: ");
		System.out.println(palidromes);
	}

	// Display Nonpalidromes
	public void printNonPalidromes() {
		System.out.print("Nonpalidromes: ");
		System.out.println(nonpalidromes);
	}

	// Getters
	public ArrayList<String> getPalidromes() {
		return palidromes;
	}

	public ArrayList<String> getNonpalidromes() {
		return nonpalidromes;
	}

	// Setters
	public void setPalidromes(ArrayList<String> palidromes) {
		this.palidromes = palidromes;
	}

	public void setNonpalidromes(ArrayList<String> nonpalidromes) {
		this.nonpalidromes = nonpalidromes;
	}
}
