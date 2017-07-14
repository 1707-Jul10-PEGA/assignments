package com.hy.q12.driver;

public class Question12 {
	public void printEvenToHundred(){
		int[] list = new int[100];
		for(int i = 1; i <= 100; i++){
			list[i-1] = i;
		}
		for(int num: list){
			if(num % 2 == 0){
				System.out.println(num);
			}
		}
	}
	
	public static void main(String[] args) {
		new Question12().printEvenToHundred();
	}
}
