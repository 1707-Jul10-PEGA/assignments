package com.aq.q16.driver;

import java.util.Scanner;

public class CountCharacters {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String arg1 = args[0];
		System.out.println(arg1.length());
		scan.close();
	}
}
