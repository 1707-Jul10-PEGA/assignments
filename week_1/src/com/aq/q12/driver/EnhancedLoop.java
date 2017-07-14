package com.aq.q12.driver;

import java.util.ArrayList;
import java.util.List;

public class EnhancedLoop {
	public static void main(String[] args) {
		int[] numbers = new int[100];
		for (int i = 0; i < 100; i++) {
			numbers[i] = i + 1;
		}
		
		for (int n:numbers) {
			System.out.print(n + ",");
		}
		
	}
}
