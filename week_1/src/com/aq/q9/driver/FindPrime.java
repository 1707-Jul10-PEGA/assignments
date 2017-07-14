package com.aq.q9.driver;

import java.util.ArrayList;
import java.math.*;
public class FindPrime {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i <= 100;i++) {
			numbers.add(i);
		}
		
		for (Integer i: numbers) {
			if(primality(i) == true) { System.out.print(i + ",");}
		}
	}
	
	public static boolean primality(Integer n) {
		if (n == 0) {return false;}
		if (n == 1) {return false;}
		if (n == 2) {return true;}
		for (Double i = 2.0; i <= n/2 ; i++) {
			if (Math.floor(n/i) == n/i) { return false;}
		}
		return true;
	}
}
