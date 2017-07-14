//Jake Maynard
//find n! for given n
package com.jntm.q4.driver;

public class Main {

	public static void main(String[] args) {
		System.out.println(factorial(10));
		
	}

	public static int factorial(int x){
		//Basic recursion. Keep feeding the factorial function until there's only one left,
		// then multiply them all at once.

		if (x < 0) {
			return 0;
		}
		
		if(x==0){
			return 1;
		}
		
		
		
		return x * factorial(x-1);
	}
}
