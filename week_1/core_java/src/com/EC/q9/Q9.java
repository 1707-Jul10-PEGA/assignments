package com.EC.q9;

import java.util.ArrayList;
import java.util.List;

public class Q9 {

	public static void main(String[] args) {
		List<Integer> arrList = new ArrayList<Integer>();
		fillList(arrList);
		printPrime(arrList);
	}
	
	public static void printPrime(List<Integer>arrList){
		for(int i : arrList){
			if(isPrime(i)){
				System.out.print(i + " ");
			}
		}
		
	}

	public static boolean isPrime(int x) {
		if (x == 1 || x == 0) {
			return false;
		}
		if(x==2){
			return true;
		}
		//check if it is a multiple of two
		if (x % 2 == 0) {
			return false;
		}
		//checks if it is a multiple of a odd #, up until the sqaureroot
		for (int i = 3; i < Math.sqrt(x); i += 2) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void fillList(List<Integer> arrList) {

		for (int i = 1; i <= 100; i++) {
			arrList.add(i);
		}
	}

}
