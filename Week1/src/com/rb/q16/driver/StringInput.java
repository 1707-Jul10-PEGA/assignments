package com.rb.q16.driver;

public class StringInput {
	
	public static void main(String args[]){
		
		String inputs = "";
		
		for(String item : args){
			inputs += item;
		}
		
		System.out.println(inputs.length() + args.length - 1);
		
	}
	
}