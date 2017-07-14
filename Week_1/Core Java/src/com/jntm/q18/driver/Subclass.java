package com.jntm.q18.driver;

public class Subclass extends Superclass{

	@Override
	public boolean meth1(String s) {
		//Test for uppercase letters in s
		if(s.equals(s.toLowerCase())){
			//this means there are no upper case letters in s
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public String meth2(String s) {
		// convert to uppercase
		return s.toUpperCase();
		
	}

	@Override
	public int meth3(String s) {
		// Convert String to int, add 10.
		return s.hashCode()+10;
	}

}
