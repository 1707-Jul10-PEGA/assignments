package com.dv.q18;

public class Strings extends StringFunctions {

	@Override
	public boolean containsUppercase(String str) {
		char[] charArray = str.toCharArray();
		
		// compare ASCII values for capital letters
		for(char c : charArray) {
			if(((int)c >= 65) && ((int)c <= 90)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String lowercaseToUppercase(String str) {
		return str.toUpperCase();
	}

	@Override
	public void addTenTo(String str) {
		try {
			int strToInt = Integer.parseInt(str);
			strToInt += 10;
			System.out.println(str + " + 10 = " + strToInt);
		}
		
		catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("String entered was not a number!");
		}
	}

}