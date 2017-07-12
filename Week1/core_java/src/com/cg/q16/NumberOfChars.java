package com.cg.q16;

public class NumberOfChars {

	public static void main(String[] args) {
		int count = 0;
		
		for(String i:args){
			count+=i.length();
		}
		System.out.println("Number of characters: " +count);
		
	}

}
