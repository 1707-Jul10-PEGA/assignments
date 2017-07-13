package com.wh.q10;

public class Q10 {
	
	private static int min(int x, int y){
		return (x<y)?x:y;
	}
	
	public static void main(String args[]){
		System.out.println("min of 0 and 100: "+min(0,100));
		System.out.println("min of 100 and 0: "+min(100,0));
		System.out.println("min of 50 and 51: "+min(50,51));
		System.out.println("min of 51 and 50: "+min(51,50));
	}
}
