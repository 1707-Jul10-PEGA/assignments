package com.as.q18.concreteclass;

import com.as.q18.abstractclass.MyAbstractClass;

public class MyConcreteClass extends MyAbstractClass{

	@Override
	public boolean checkForUpper(String s) {
		//run through the string and check if each character
		//is upper case
		for(int i = 0; i < s.length(); i++) {
			//if the char at the indexed position is between A and Z then
			//it is an upper case character and it returns having found
			//an upper case character
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertToLower(String s) {
		return s.toLowerCase();
	}

	@Override
	public void convertToInt(String s) {
		Integer i;
		try {
			i = Integer.valueOf(s);
			System.out.println("The value of your string is: " + i);
		} catch (NumberFormatException e) {
			System.out.println("String was not a number.");
		}
	}

}
