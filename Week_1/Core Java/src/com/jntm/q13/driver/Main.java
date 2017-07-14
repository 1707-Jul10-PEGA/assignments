package com.jntm.q13.driver;

public class Main {

	public static void main(String[] args) {
		//Display the pyramid of 1s and 0s.

		//y acts as a boolean flag to alt between 1's and 0's
		boolean y = true;
		
		//One cycle for each layer of pyramid
		for (int x = 1; x < 5; x++) {
			//z controls the length of the rows
			int z = x;
			//Print
			while (z > 0) {
				if (y) {
					System.out.print(0 + " ");
					y = false;
				} else {
					System.out.print(1 + " ");
					y = true;
				}
				z--;
			}
			System.out.println("\n");
		}

	}

}
