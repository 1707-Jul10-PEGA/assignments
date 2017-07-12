package com.cg.q10;

public class TernaryOperators {
	
	public static int minValue(int x, int y){
		return (x<y) ? x:y;
	}
	
	public static void main(String [] args){
		System.out.println(minValue(3,5));
		System.out.println(minValue(5,1));
	}
}
