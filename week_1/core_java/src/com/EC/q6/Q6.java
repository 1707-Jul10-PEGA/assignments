package com.EC.q6;

public class Q6 {

	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < array.length; i++) {
			if (Q6.isEven(array[i])) {
				System.out.println(array[i] + " is Even");
			} else {
				System.out.println(array[i] + " is odd");
			}
		}
	}

	public static boolean isEven(int x) {
		// x AND 1 by bits will always equal 0 if x is even
		if ((x & 1) == 0) {
			return true;
		} else {
			return false;
		}
	}

}
