package com.AF.q13;

public class Q13 {
	public static void printTriangle(int level) {
		int flip = 0;
		for (int i = 0; i < level; i ++) {
			for (int j = 0; j < i+1; j ++) {
				System.out.print(flip + " ");
				flip = (flip + 1) % 2;
			}
			System.out.print("\n");
		}
	}
	public static void main(String[] args) {
		printTriangle(5);
	}
	
}
