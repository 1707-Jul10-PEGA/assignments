package com.MS.Q18.driver;

/*
 * The child class has 3 overridden methods. First, it has a method
 * to check for uppercase letters. It returns a boolean with the answer.
 * 
 * The second method simply converts the supplied string to uppercase.
 * 
 * The third method turns the supplied string (which SHOULD be an integer)
 * into an integer and adds 10 to it before returning it.
 */
public class Child extends Inheritance
{
	boolean flag = false;
	String strret = "";
	int intret = 0;
	@Override
	boolean upperCase(String s) {
		if(s.toLowerCase().equals(s.toString()))
		{
			flag = false;
		}
		else
		{
			flag = true;
		}
		return flag;
	}
	@Override
	String toUpper(String s) {
		
		strret = s.toUpperCase();
		return strret;
	}

	@Override
	int plusToInt(String s) {
		
		intret = Integer.parseInt(s);
		return intret + 10;
	}


}
