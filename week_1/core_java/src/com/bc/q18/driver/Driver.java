package com.bc.q18.driver;

public class Driver {
	public static void main(String[] args) {
		Child c = new Child();
		c.printAdd10("20");
		System.out.println(c.checkUppercase("baaaaaaaaaaaMljkhasdlfb3iukhbdf"));
		System.out.println(c.toUpper("adskjfnsadlkjfn"));
	}
}

abstract class Parent {
	public abstract boolean checkUppercase(String s);

	public abstract String toUpper(String s);

	public abstract void printAdd10(String s);
}

class Child extends Parent {

	@Override
	public boolean checkUppercase(String s) {
		// TODO Auto-generated method stub
		// finds any uppercase in the string
		return s.matches(".*[A-Z].*");
	}

	@Override
	public String toUpper(String s) {
		// TODO Auto-generated method stub
		return s.toUpperCase();
	}

	@Override
	public void printAdd10(String s) {
		// TODO Auto-generated method stub
		try {
			int p = Integer.parseInt(s);
			p += 10;
			System.out.println(p);
		} catch (NumberFormatException e) {
			System.out.println("Failed to parse");
			e.printStackTrace();
		}

	}

}
