package com.bc.q3.driver;

public class Driver {
	public static String reverseStr(String arg){
		
		// the string mirrors itself. 
		for(int i = arg.length()-1; i >= 0; i--){
			//very inefficient with large strings, due to string pool
			arg += arg.charAt(i);
		}
		// take the right half the the string, return that.
		arg = arg.substring(arg.length() / 2, arg.length());
		return arg;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		System.out.println(reverseStr(str));
	}

}
