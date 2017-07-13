//Jake Maynard
//Reverse a given String
package com.jntm.q3.driver;

public class Main {
	public static void main(String[] args) {
		String normal = "Hello World!";
		 
		System.out.println(reverse(normal));
		
	}
	
	public static String reverse(String normal){
		//The string gets reversed incrementally, and returned.
		int len = normal.length();
		
		String reversed ="";
		
		
		for(int x = len-1; x>=0 ;x-- ){
			reversed+=normal.charAt(x);	
		}
		
		return reversed;
	}
}
