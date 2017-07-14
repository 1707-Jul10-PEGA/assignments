package com.hy.q3.driver;

public class Question3 {
	public String reverse(String str){
		StringBuffer sb = new StringBuffer(str);
		String res = "";
		for( int i = 0; i < sb.length(); i++){
			res = sb.charAt(i) + res;
		}
		return res;
	}
	
	public static final void main(String[] args){
		String str = "abcdefghijklmnopqrstuvwxyz";
		String res = new Question3().reverse(str);
		System.out.println("String: " + str);
		System.out.println("Reverse String: " + res);
	}
}
