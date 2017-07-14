package com.dv.q16;

public class CharacterInput {

	public static void main(String[] args) {
		String str = "";
		
		// concatenate the arguments into a single string
		for(String s : args) {
			str += s;
		}
		
		System.out.println(str.length());
	}

}
