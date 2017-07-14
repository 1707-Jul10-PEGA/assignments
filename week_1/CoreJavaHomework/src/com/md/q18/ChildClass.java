package com.md.q18;

import java.lang.*;

public class ChildClass extends AbstractClassParent {

	@Override
	public boolean checkUpperCase(String s) {

		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpperCase(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(Character.toUpperCase(s.charAt(i)));
		}
		return sb.toString();
	}

	@Override
	public int stringToIntPlusTen(String s) {
		int number = Integer.parseInt(s)+10;
			
		return number;
	}

}
