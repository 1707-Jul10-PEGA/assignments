package com.rb.q5.driver;

import java.util.Scanner;

public class Substring {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Substring();
		
	}
	
	public Substring(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Input string: ");
		String string = scan.nextLine();
		System.out.print("Input index: ");
		int index = scan.nextInt();
		scan.close();
		System.out.println(this.substring(string, index));
	}
	
	private String substring(String str, int idx){
		String output = "";
		
		for(int i = 0; i < idx; i++){
			output += str.charAt(i);
		}
		
		return output;
	}
	
}
