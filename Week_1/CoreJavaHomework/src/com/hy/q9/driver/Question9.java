package com.hy.q9.driver;

import java.util.ArrayList;

//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console
public class Question9 {
	public void printPrimeToHundred(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++){
			list.add(i);
		}
		System.out.println("Prime numbers: ");
		for(int i = 1; i < list.size(); i++){
			int num = list.get(i);
			if(isPrime(num)){
				System.out.print(num + " ");
			}
			
			
			
		}
		
	}
	
	private boolean isPrime(int num){
		for(int j = 2; j <= num/2; j++){
			if(num % j == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		new Question9().printPrimeToHundred();
	}
}
