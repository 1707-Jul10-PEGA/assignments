package com.EC.q5;

public class Q5 {

	public static void main(String[] args) {
		
		String str = "dide";
		
		String subString = subString(str,3);
		
		System.out.println(subString);

	}
	
	public static String subString(String str, int idx){
		
		StringBuilder subString = new StringBuilder();
		
		for(int i=0; i<idx;i++){
			subString.append(str.charAt(i));
		}
		
		return subString.toString();
		
	}

}
