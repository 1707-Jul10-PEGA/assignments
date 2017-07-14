package com.revature.ddh.question12;

import java.util.ArrayList;

public class Launch {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i <=100; i++) {
			arr.add(i);
		}
		
		for(int k : arr) {
			if (k % 2 == 0) {
				System.out.println(k);
			}
			
			
		}
		
	}
	
	
}
