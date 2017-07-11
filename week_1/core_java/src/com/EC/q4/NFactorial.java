package com.EC.q4;

public class NFactorial {
	
	public static int factorial(int N){
		//exit condition
		if(N<=1){
			return 1;
		}
		return N*factorial(N-1);
	}
}
