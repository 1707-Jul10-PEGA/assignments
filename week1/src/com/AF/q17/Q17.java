package com.AF.q17;

import java.util.Scanner;

public class Q17 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		double principal, rate, time = 0;
		
		while (true) {
			System.out.print("Principal: ");
			try {
				principal = Double.parseDouble(s.nextLine());
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("Error: Invalid Input");
			}
		}
		while (true) {
			System.out.print("Rate: ");
			try {
				rate = Double.parseDouble(s.nextLine());
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("Error: Invalid Input");
			}
		}
		while (true) {
			System.out.print("Time: ");
			try {
				time = Double.parseDouble(s.nextLine());
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("Error: Invalid Input");
			}
		}
		System.out.println("Interest: " + principal*rate*time);
		s.close();
		
	}
}
