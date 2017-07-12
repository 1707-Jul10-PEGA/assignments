package com.EC.q4;

public class Q4 {
	
	public static void main(String[] args){
		System.out.println("15! = " + factorial(15));
	}
	
	public static int factorial(int N){
		//exit condition
		if(N<=1){
			return 1;
		}
		return N*factorial(N-1);
	}
}
