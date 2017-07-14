package com.hy.q16.driver;

public class Question16 {
	public Question16(){
		
	}
	
	private int displayNumChar(String str){
		System.out.println("String: " + str + " | number of characters: " + str.length());
		return str.length();
	}
	
	public static void main(String[] args) {
		new Question16().displayNumChar(args[0]);
	}
}
