package com.wh.q18;

public class Main {
	public static void main(String[] args) {
		Q18Sub q = new Q18Sub();
		System.out.println("hasUpperCase Check using @[: " + q.hasUpperCase("@["));
		System.out.println("hasUpperCase Check using AZ: " + q.hasUpperCase("AZ"));
		System.out.println("toUpperCase Check using all lower case: " + q.toUpperCase("all lower case"));
		System.out.print("toIntegerAddTen Check using abc: ");
		q.toIntAddTen("abc");
		System.out.print("toIntegerAddTen Check using 100: ");
		q.toIntAddTen("100");
	}
}
