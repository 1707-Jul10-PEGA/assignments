package com.revature.ddh.q4;

public class Factorial {
	
	public  int  factorial(int n) {
		// TODO Auto-generated method stub

		if (n == 1) {
			return 1;
		}
		else {
		
		return n * (factorial(n-1));
		}
	}

}
