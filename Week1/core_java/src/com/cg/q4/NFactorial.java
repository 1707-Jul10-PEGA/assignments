package com.cg.q4;

public class NFactorial {

	public static int nFactorial(int n){
		
		//Base Cases
		if(n == 1 || n == 0){
			return 1;
		}else if(n == 2){
			return 2;
		}
		
		//Otherwise
		else{
			return n*nFactorial(n-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(nFactorial(4));
	}

}
