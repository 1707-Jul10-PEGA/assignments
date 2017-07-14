package com.nc.q18;

public class MySubclass extends MySuperclass{

	@Override
	boolean upperCase(String str) {
		//Create a string that is only lowercase
		String upperCase = str.toLowerCase();
		//if the strings are equal then the input has only lowercases
		if(upperCase.equals(str))
		{
			return false;
		}
		//if the strings are not equal then the input has at least 1 uppercase
		else
		{
			return true;
		}
	}

	@Override
	String lowerToUpper(String lower) {
		//Simple string method to convert lowercases to uppercases
		return lower.toUpperCase();
	}

	@Override
	void strToInt(String num) {
		//Convert string to int
		int conv = Integer.parseInt(num);
		//add 10
		conv = conv + 10;
		System.out.println(conv);
	}

}
