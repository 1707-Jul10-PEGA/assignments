package com.bc.q14.driver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		int x = 0;
		Scanner scan = new Scanner(System.in);
		String s = null;
		// Traps user until valid option is picked
		while (true) {
			System.out.print("Pick 1, 2, 3 : ");
			s = scan.nextLine();
			try {
				x = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				System.out.println("    **** Invalid input ****");
				break;
			}
			if (x <= 3 && x >= 1) {
				scan.close();
				break;
			} else {
				System.out.println("  ** Enter the correction option **");
			}
		}
		switch (x) {
		case 1:
			System.out.println("Square root of 2 is " + Math.sqrt(2.0));
			break;
		case 2:
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));
			break;
		case 3:String[] splitArr = "I am learning Core Java".split(" ");
			break;
		}
	}
}
