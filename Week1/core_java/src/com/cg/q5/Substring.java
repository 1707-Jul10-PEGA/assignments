package com.cg.q5;

public class Substring {
	
	public static void main(String[] args) {
		Substring s = new Substring();
		System.out.println("Hello");
		System.out.println("Substring at index 2 is " +s.subString("Hello",2));
		
	}
	
	public String subString(String str, int index){
		char [] str1 = new char[str.length()];
		
		for(int i = 0; i < index; i++){
			str1[i] = str.charAt(i);
		}
		
		return  new String(str1);
	}

	

}
