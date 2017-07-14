package com.bc.q5.driver;

public class Driver {
	public static String subStr(String str, int idx){
		String ret = "";
		// basically 'append' from start to end. Starting with the empty string.
		for(int i = 0; i < idx && i < str.length(); i++){
			ret += str.charAt(i);
		}
		return ret;
	}
	public static void main(String[] args) {
		System.out.println(subStr("hello", -1));
		System.out.println(subStr("hello",3));
		System.out.println(subStr("hello",20));
	}
}
