//Jake Maynard
//Take a substring of 0 to idx
package com.jntm.q5.driver;

public class Main {

	public static void main(String[] args) {

		System.out.println(sub("Hello World!", 10));
	}

	public static String sub(String str, int idx) {
		String product = "";

		int limit=0;
		
		//Find the shorter value.
		if (str.length() >= (idx)) {
			limit = idx;
		}
		else{
			limit = str.length();
		}
		
		//Just append that value's worth of chars from the string to return it
		for (int x = 0; x < limit; x++) {
			product+=str.charAt(x);
		}

		return product;
	}
}
