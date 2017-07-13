package com.cg.q18;

public class TestAB {
	public static void main(String [] args) {
		B b = new B();
		
		//Check for uppercase using ASCII
		System.out.println(b.checkForUppercase("he'll%&*$o _h \"a"));
		
		//Convert to Upper case
		System.out.println("hAB'll%&*$O _h \"a");
		System.out.println(b.convertToUppercase("hAB'll%&*$O _h \"a"));
		
		//Convert string to int and add 10
		b.convertStringToInt("HelloWorld");
		b.convertStringToInt("Hello 50 World");
		b.convertStringToInt("Hello -50 World");
		b.convertStringToInt("Hello 50- World");
	}
}
