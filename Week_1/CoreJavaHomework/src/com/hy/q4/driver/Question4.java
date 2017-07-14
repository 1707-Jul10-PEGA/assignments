package com.hy.q4.driver;

import com.hy.q3.driver.Question3;

//Write a program to compute N factorials
public class Question4 {
	public int factorial(int n){
		int res = 1;
		for( int i = 1; i <= n; i++){
			res *= i;
		}
		return res;
	}
	
	public static final void main(String[] args){
		Question4 q4 = new Question4();
		System.out.println("Result of 4!: " + q4.factorial(4));
		System.out.println("Result of 8!: " + q4.factorial(8));
		System.out.println("Result of 9!: " + q4.factorial(9));
		System.out.println("Result of 10!: " + q4.factorial(10));
	}
}
