package com.AF.q5;

public class Q5 {
	
	public static String getSubString(String str, int idx) {
		char[] sub_array = str.toCharArray();
		String sub_str = "";
		for (int i = 0; i < idx; i++) {
			sub_str += sub_array[i];
		}
		return sub_str;
	}
	
	public static void main (String[] args) {
		System.out.println(getSubString("String to be modified", 10));
	}
}
