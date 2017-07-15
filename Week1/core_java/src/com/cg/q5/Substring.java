package com.cg.q5;

public class Substring {

	// Returns the substring between 0 and the index provided
	public String subString(String str, int index) {
		char[] str1 = new char[str.length()];

		for (int i = 0; i < index; i++) {
			str1[i] = str.charAt(i);
		}

		return new String(str1);
	}

}
