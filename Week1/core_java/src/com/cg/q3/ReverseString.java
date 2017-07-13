package com.cg.q3;

public class ReverseString {
	public String reverseString(String str) {

		for (int i = str.length() - 1; i >= 0; i--) {
			str = str.concat(String.valueOf(str.charAt(i)));
		}
		return str.substring(str.length() / 2);

	}

	public static void main(String[] args) {
		ReverseString r = new ReverseString();

		System.out.println(r.reverseString("He"));

	}
}
