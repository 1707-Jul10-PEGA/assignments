package com.cg.q10;

public class TernaryOperators {
	
	//Returns the minimum value of two numbers
	public int minValue(int x, int y){
		return (x<y) ? x:y;
	}
	
	public static void main(String [] args){
		TernaryOperators t = new TernaryOperators();
		
		System.out.print("What's the minimum value of 3 and 5: ");
		System.out.println(t.minValue(3,5));
		System.out.print("What's the minimum value of 5 and 1: ");
		System.out.println(t.minValue(5,1));
	}
}
