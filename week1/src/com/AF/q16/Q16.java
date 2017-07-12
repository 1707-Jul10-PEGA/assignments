package com.AF.q16;

public class Q16 {
	public static void main(String[] args) {
		
		int count = 0;
		for (String s : args) {
			count += s.split("").length;
		}
		System.out.println(count);
	}
}
