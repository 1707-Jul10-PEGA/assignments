package com.AF.q10;

public class Q10 {
	
	public static void findMin(int a, int b) {
		System.out.println(" Min of " + a + " " + b + ": " + ((a < b) ? a : b));
	}
	public static void main(String[] args) {
		findMin(15, 26);
		findMin(39, 28);
		findMin(100000005, 1);
	}
}
