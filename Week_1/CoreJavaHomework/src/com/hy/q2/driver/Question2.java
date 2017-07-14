package com.hy.q2.driver;
//Write a program to display the first fibonacci number beginning at 0
public class Question2 {
	public int[] fibonacci(int num){
		int arr[] = new int[num];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i < num; i++){
			arr[i] = arr[i-1]+arr[i-2];
		}
		return arr;
	}
	
	public static final void main(String[] args){
		int[] res = new Question2().fibonacci(25);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
	}
}
