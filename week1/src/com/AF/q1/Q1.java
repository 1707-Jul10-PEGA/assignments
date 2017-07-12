package com.AF.q1;

public class Q1 {
	public static void main (String[] args) {
		int[] a =  {1,0,5,6,3,2,3,7,9,8,4};
		for (int i = 0; i < a.length; i++){
			for (int j=i; j < a.length-1; j++) {
				for (int k = j+1; k < a.length; k++) {
					if (a[j] > a[k]) {
						int temp = a[j];
						a[j] = a[k];
						a[k] = temp;
					}
				}
			}
		}
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i]);
		}
	}
	
}
