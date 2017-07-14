package com.aq.q1.driver;

import java.util.Arrays;

public class Question_One {
	public static void main (String[] args) {
		int[] a = {1,0,5,6,3,2,3,7,9,8,4};	
		System.out.println(Arrays.toString(Question_One.bubbleSort(a)));
	}
	
	private static int[] bubbleSort(int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array);
			int pointer = i;
			int afterPointer = pointer + 1;
			while(pointer < array.length - 1) {
				if (array[pointer] > array[afterPointer]) {
					int temp = array[pointer];
					array[pointer] = array[afterPointer];
					array[afterPointer] = temp;
					}
				pointer++;
				afterPointer++;
				}
			}
		return array;
		}
}

