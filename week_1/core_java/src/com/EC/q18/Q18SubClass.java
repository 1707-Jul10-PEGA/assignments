package com.EC.q18;

public class Q18SubClass extends Q18Abstract {

	@Override
	public boolean hasUpperCase(String str) {
		char[] ch = str.toCharArray();
		for (char c : ch) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpperCase(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			if (Character.isLowerCase(sb.charAt(i))) {
				sb.setCharAt(i,Character.toUpperCase(sb.charAt(i)));
			}
		}
		return sb.toString();
	}

	@Override
	public int toIntPlusTen(String str) {
		return Integer.parseInt(str) + 10;
	}

}
