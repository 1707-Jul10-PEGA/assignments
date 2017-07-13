package com.wh.q2;

import java.util.ArrayList;

/**
 * Write a program to display the first 25 Fibonacci numbers  beginning with 0.
 * @author - Wei Huang
 */

public class Q2 {
	
	public static void main(String args[]){
		ArrayList<Integer> fibNums = new ArrayList<Integer>();
		fibNums.add(0);
		fibNums.add(1);
		for(int i = 1; i < 24; i++){
			fibNums.add(fibNums.get(i)+fibNums.get(i-1));
		}
		System.out.print(fibNums.toString());
	}
}
