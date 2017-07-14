package com.aq.q13.driver;

public class BinaryLoop {
	public static void main(String[] args) {
		String s = "";
		String c = "";
		int n = 0;
		for (int i = 0;i<4;i++) {
			if (n % 3 == 0) {c = "0 ";}
			else 			{c = "1 ";}
			if (i%2==0) {
				s = s + c;
			}
			else {
				s = c + s;
			}
			System.out.println(s);
			System.out.println();
			n += 1;
		}
	}
}
