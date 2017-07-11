package com.EC.test;
import com.EC.q1.*;
import com.EC.q2.Fibonacii;
import com.EC.q4.NFactorial;
public class test {

	public static void main(String[] args) {
		//Q1 test
		System.out.println("----------------------------");
		System.out.println("-----------QUESTION1--------");
		System.out.println("----------------------------");

		int[] test = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		System.out.println("Before Bubble Sort");
		BubbleSort.printArray(test);
		BubbleSort.bubbleSort(test);
		System.out.println("After Bubble Sort");
		BubbleSort.printArray(test);
		
		
		System.out.println("----------------------------");
		System.out.println("-----------QUESTION2--------");
		System.out.println("----------------------------");
		
		Fibonacii.printFibonacci(25);
		
		System.out.println("----------------------------");
		System.out.println("-----------QUESTION4--------");
		System.out.println("----------------------------");
		
		System.out.println("15! = " + NFactorial.factorial(15));
	}
}
