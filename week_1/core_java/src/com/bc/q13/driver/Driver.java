package com.bc.q13.driver;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		// Here is a convoluted way to print out the numbers
		for (int i = 0; i < 4; i++) {
			// append back
			if (i % 2 == 0) {
				if (((i + 1) / 2) % 2 == 0) {
					str += (str.length() != 0) ? " 0" : "0" ;
				} else {
					str += " 1";
				}
			}
			// front append
			else {
				if (((i + 1) / 2) % 2 == 0) {
					str = "0 " + str;
				} else {
					str = "1 " + str;
				}

			}
			System.out.println(str);
		}
	}

}
