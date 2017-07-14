package com.bc.q4.driver;

public class Driver {
	public static int factorial(int n){
		int ret = 1;
		// basically repeat multiplication
		for(int i = 1 ; i <= n; i++){
			ret *= i;
		}
		return ret;
	}
	public static void main(String[] args){
		System.out.println(factorial(5));
	}
}
