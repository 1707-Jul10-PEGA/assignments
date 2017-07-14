package com.rb.q5.driver;

import java.util.Scanner;

public class Substring {
	
	public static void main(String[] args) {
		
		new Substring();
		
	}
	
	public Substring(){
		// scan in a string, then an integer, then call
		// the substring method
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Input string: ");
		String string = scan.nextLine();
		System.out.print("Input index: ");
		int index = scan.nextInt();
		scan.close();
		
		// print output
		System.out.println(this.substring(string, index));
	}
	
	private String substring(String str, int idx){
		// create output as empty string.
		String output = "";
		
		
		// for every index less than the integer passed in,
		// add that character to the output string
		for(int i = 0; i < idx; i++){
			output += str.charAt(i);
		}
		
		// return output
		return output;
	}
	
}
