package com.dv.q10.driver;

import java.util.Scanner;

public class Ternary {

	public static int getMin(int x, int y) {
		return (x < y) ? x : y;
	}

	public static void main(String[] args) {
		int x = 0, y = 0;
		Scanner read = new Scanner(System.in);
		
		System.out.println("Enter two numbers: ");
		x = read.nextInt();
		y = read.nextInt();
		
		System.out.println(getMin(x, y) + " is the lesser number.");
	}

}
