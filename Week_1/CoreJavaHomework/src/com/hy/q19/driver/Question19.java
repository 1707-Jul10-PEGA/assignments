package com.hy.q19.driver;

import java.util.ArrayList;

public class Question19 {
	public void question19(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++){
			list.add(i);
		}
		System.out.println("ArrayList list: " + list);
		int even = 0;
		int odd = 0;
		for(int it = 0; it < list.size(); it++){
			int num = list.get(it);
			if(num % 2 == 0){
				even += num;
			}
			else{
				odd += num;
			}
			
			if(num > 1 && isPrime(num)){
				list.remove(it);
				it--;
			}
		}
		System.out.println("Sum of Even numbers: " + even);
		System.out.println("Sum of Odd numbers: " + odd);
		System.out.println(list);
		
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
		new Question19().question19();
	}
}
