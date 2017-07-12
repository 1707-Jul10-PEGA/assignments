package com.AF.q6;

public class Q6 {
	public static void main (String[] args) {
		int randomInt = 13553535;
		String result = (((randomInt << 31) >>> 31) == 1) ? "Not an even" : "Even";
		System.out.print(result);
	}
	
}
