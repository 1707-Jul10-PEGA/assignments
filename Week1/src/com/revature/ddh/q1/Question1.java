package com.revature.ddh.q1;

import java.util.Arrays;

public class Question1 {

	
	public static int[] sort(int[] x) {

		for (int j = 0; j < x.length -1; j++) {
			for (int i = 0; i < x.length -1; i++) {
				if (x[i] > x[i + 1]) {
					int temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
					System.out.println(Arrays.toString(x));

				}
			}

		}

		return x;
	}
	
		
		public static void main(String[] args) {
			int[] a = {1,0,5,6,3,2,3,7,9,8,4};
			sort(a);
			
		}

	}


