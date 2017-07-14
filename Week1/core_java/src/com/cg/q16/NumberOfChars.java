package com.cg.q16;

public class NumberOfChars {

	public static void main(String[] args) {
		int count = 0;
		
		//Counts number of characters including white spaces
		for(String i:args){
			count+=i.length()+1;
		}
		System.out.println("Number of characters: " +count);
		
	}

}
