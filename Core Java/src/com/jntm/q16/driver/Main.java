package com.jntm.q16.driver;

public class Main {

	public static void main(String[] args) {
		//Display length of input string argument.
		
		//Check if there was an input, then output length.
		if(args.length!=0){
			System.out.println(args[0].length());
		}
		else{
			System.out.println("Please input a string.");
		}
		
		
	}

}
