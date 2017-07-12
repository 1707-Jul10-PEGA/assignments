package com.EC.q13;

public class Q13 {

	public static void main(String[] args) {

		printTree(4);

	}

	public static void printTree(int levels) {
		boolean zero = true;

		for (int i = 1; i <= levels; i++) {
			for (int j = 1; j <= i; j++) {
				if (zero) {
					System.out.print("0 ");
					zero = false;
				} else {
					System.out.print("1 ");
					zero = true;
				}
			}
			System.out.print("\n");
		}
	}

}
