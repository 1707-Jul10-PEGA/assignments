package com.AF.q18;

abstract class ParentClass {
	abstract boolean checkUpper(String s);
	abstract String upper(String s);
	abstract void add10(String s);
}

class ChildClass extends ParentClass {
	
	@Override
	boolean checkUpper(String s) {
		char[] s_charArray = s.toCharArray();
		for (char sc : s_charArray) {
			Character.isUpperCase(sc);
			return true;
		}
		return false;
	}

	@Override
	String upper(String s) {
		return s.toUpperCase();
	}

	@Override
	void add10(String s) {
		try {
			int temp = Integer.parseInt(s);
			System.out.println(10 + temp);
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		}
		
	}
	
}


public class Q18 {
	public static void main(String[] args) {
		ChildClass cClass = new ChildClass();
		System.out.println(cClass.checkUpper("Hello Word"));
		System.out.println(cClass.upper("Hello World"));
		cClass.add10("5");
		cClass.add10("Hello World");
	}
}
