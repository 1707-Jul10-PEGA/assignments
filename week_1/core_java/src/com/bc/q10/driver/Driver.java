package com.bc.q10.driver;

public class Driver {

	public static int maxInt(int first, int second){
		return (first >= second) ? first:second  ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;
		int y = 6;
		System.out.println("The max of two numbers (" + x + " , " + y + "): " + maxInt(x,y));

	}

}
