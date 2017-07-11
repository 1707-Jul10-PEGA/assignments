package com.cg.q2;

public class Fibonnacci {

	public static int fib(int n){
		//Base Cases
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}
		
		//If n is greater than 1
		else{
			return fib(n-1)+fib(n-2);
		}
	}
	public static void main(String[] args) {
		
		for(int i = 0; i < 25; i++){
			System.out.println(fib(i));
			
		}
	}

}

