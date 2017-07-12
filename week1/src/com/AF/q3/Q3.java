package com.AF.q3;

public class Q3 {
	public static void main(String[]args) {
		String str = "string";
		char[] result = new char[str.length()];
		
		for (int i = 0; i < Math.ceil((double)str.length()/2); i++) {
			if (i == result.length-1-i) {
				result[i] = str.charAt(i);
				continue;
			}
			
			 result[i] = (char)(str.charAt(str.length()-1-i)^str.charAt(i));
			 result[str.length()-1-i] = (char)(str.charAt(str.length()-1-i)^result[i]);
			 result[i] = (char)(result[str.length()-1-i]^result[i]);
		};
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}
