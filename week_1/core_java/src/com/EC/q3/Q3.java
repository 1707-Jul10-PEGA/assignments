package com.EC.q3;

public class Q3 {
	
	public static void main(String[] args){
				
		String str = "Elliot";
		System.out.println("String before call to reverse: "  + str);
		str = reverse(str);
		System.out.println("String afterwards: " + str);
		
	}
	
	public static String reverse(String str){
		//exit case
		if(str.length()==0){
			return "";
		}
		return str.charAt(str.length()-1) + reverse(str.substring(0, str.length()-1));
	}
	
}
