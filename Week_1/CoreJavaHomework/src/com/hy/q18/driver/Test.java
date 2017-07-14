package com.hy.q18.driver;

public class Test {
	public static void main(String[] args) {
		Question18 q = new Question18();
		System.out.println("Testing ... isThereUppercase(\"there is no uppercase\"): " + q.isThereUppercase("there is no uppercase"));
		System.out.println("Testing ... isThereUppercase(\"theRe is UppeRcaSe\"): " + q.isThereUppercase("theRe is UppeRcaSe"));
		System.out.println("Testing ... toUppercaseString(\"uppercase string\"): " + q.toUppercaseString("uppercase string"));
		System.out.println("Testing ... convertStringToInteger(\"98\"): " + q.convertStringToInteger("98"));

	}
}
