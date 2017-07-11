package com.cg.q5;

public class Substring {
	
	public static String subString(String str, int index){
		char [] str1 = new char[str.length()];
		
		for(int i = 0; i < index; i++){
			str1[i] = str.charAt(i);
		}
		
		return  new String(str1);
	}

	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println(subString("Hello",2));
		
	}

}
