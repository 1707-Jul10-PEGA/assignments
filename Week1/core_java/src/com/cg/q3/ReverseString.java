package com.cg.q3;

public class ReverseString {
	public String reverseString(String str) {

		for (int i = str.length() - 1; i >= 0; i--) {
			str = str.concat(String.valueOf(str.charAt(i)));
		}
		return str.substring(str.length() / 2);

	}
	
	public String reverseString1(String str) {
		System.out.println(str);
		if(str.length() == 1){
			//System.out.println(str);
			return str;
		}else{
			return reverseString1(str.substring(0, str.length()-1)) ;
		}

	}

	public static void main(String[] args) {
		ReverseString r = new ReverseString();

		System.out.println(r.reverseString("Hello"));
		System.out.println("String1 = " + r.reverseString1("Hello"));

	}
}
