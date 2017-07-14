package com.bc.q17.driver;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	public static double getInterest(double principal, double rate, double time) {
		if (rate < 0) {
			return 0;
		}
		if (time < 0) {
			return 0;
		}
		if (principal < 0) {
			return 0;
		}
		return principal * rate * time;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double principal = 0;
		double rate = 0;
		double time = 0;
		while (true) {
			System.out.print("Enter principal: ");
			try {
				principal = scan.nextDouble();
				break;
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}
		while (true) {
			System.out.print("Enter rate: ");
			try {
				rate = scan.nextDouble();
				break;
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}
		while (true) {
			System.out.print("Enter time: ");
			try {
				time = scan.nextDouble();
				break;
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Interest to pay: " + getInterest(principal, rate, time));
	}
}
