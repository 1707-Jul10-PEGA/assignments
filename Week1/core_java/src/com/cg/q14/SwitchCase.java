package com.cg.q14;

import java.time.LocalDate;

public class SwitchCase {
	public static void main(String[] args) {
		SwitchCase sw = new SwitchCase();

		for (int i = 1; i < 4; i++) {
			sw.switchCase(i);
		}

	}
	//Call methods depending on user choice
	public void switchCase(int choice) {
		switch (choice) {
		case 1:
			sqrt(Math.random());
			break;
		case 2:
			printDate();
			break;
		case 3:
			printArray(splitString("I am learning Core Java"));
			break;
		}
	}

	// Calculate and print the square root of n
	public void sqrt(double n) {
		System.out.println("The square root of " + n + " is " + Math.sqrt(n));
	}

	// Prints today's date using LocalDate
	public void printDate() {
		System.out.println(LocalDate.now());
	}

	// Splits a string using split and returns an array of strings
	public String[] splitString(String str) {
		return str.split(" ");
	}

	// Prints out an String array
	public void printArray(String[] arr) {
		System.out.print("[");
		for (String k : arr) {
			if (k.equals(arr[arr.length - 1])) {
				System.out.print(k);
			} else {
				System.out.print(k + ",");
			}
		}
		System.out.println("]");
	}
}
