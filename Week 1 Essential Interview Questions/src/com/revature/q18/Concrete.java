package com.revature.q18;

public class Concrete extends MyAbstract{

	@Override
	boolean isUpperThere(String in) {
		return !in.equals(in.toLowerCase());
	}

	@Override
	String toUpperCase(String in) {
		return in.toUpperCase();
	}

	@Override
	void toInterPlusTen(String in) {
		int toGo = Integer.parseInt(in);
		System.out.println(toGo + 10);
	}	
	
}
