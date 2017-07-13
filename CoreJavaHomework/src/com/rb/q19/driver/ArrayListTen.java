package com.rb.q19.driver;

import java.util.ArrayList;

public class ArrayListTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> ten = new ArrayList<Integer>();
		
		for(int i = 1; i<=10; i++){
			ten.add(i);
		}
		
		System.out.println(ten);
		
		int evenSum = 0;
		
		for(int i = 1; i < 10; i += 2){
			evenSum += ten.get(i);
		}
		
		System.out.println("sum of even numbers: " + evenSum);
		
		int oddSum = 0;
		
		for(int i = 0; i < 10; i += 2){
			oddSum += ten.get(i);
		}
		
		System.out.println("sum of odd numbers: " + oddSum);
		
		for(int i = 1; i <10; i++){
			if(i>=ten.size()){
				break;
			}
			int num = ten.get(i);
			boolean prime = true;
			for(int j = 2; j < num; j++){
				if(!prime){
					break;
				}
				if(num%j == 0){
					prime = false;
				}
			}
			if(prime){
				ten.remove(i);
				i--;
			}
		}
		
		System.out.println(ten);
	}
}