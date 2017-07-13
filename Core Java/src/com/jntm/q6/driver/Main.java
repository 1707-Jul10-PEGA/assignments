package com.jntm.q6.driver;

public class Main {

	public static void main(String[] args) {
		//Checks for even-ness without using %
		System.out.println(isEven(5));
		System.out.println(isEven(6));
		System.out.println(isEven(7));
		System.out.println(isEven(8));
	}
	
	public static boolean isEven(int num){
		//Because of the way integers work in Java,
		//Halving and doubling an odd number will 
		//result in a loss of value that an even number
		//will not experience.
		int check = num / 2 * 2;
		
		if(check==num){
			return true;
		}
		else{
			return false;
		}
		
	}
}
