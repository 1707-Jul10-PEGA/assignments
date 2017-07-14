package com.rb.q16.driver;

public class StringInput {
	
	public static void main(String args[]){
		
		// create empty string
		String inputs = "";
		
		// concatenate each argument input to
		// empty string
		for(String item : args){
			inputs += item;
		}
		
		// input string has spaces, one less than
		// the number of arguments.
		System.out.println(inputs.length() + args.length - 1);
		
	}
	
}