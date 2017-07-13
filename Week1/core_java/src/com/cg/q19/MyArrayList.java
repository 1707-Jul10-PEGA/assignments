package com.cg.q19;

import java.util.ArrayList;

public class MyArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> myArrayList = new ArrayList<Integer>();
		int even = 0;
		int odd = 0;

		for (int i = 1; i <= 10; i++) {
			myArrayList.add(i);
		}

		for (Integer i : myArrayList) {
			if ((i % 2) == 0) {
				even += i;
			} else {
				odd += i;
			}
		}

		System.out.println("The sum of all the even numbers is " + even);
		System.out.println("The sum of all the odd numbers is " + odd);
		
		//Todo Prime
	}
}
