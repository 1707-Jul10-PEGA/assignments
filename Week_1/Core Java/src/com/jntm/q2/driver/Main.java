//Jake Maynard
//Fibonacci Sequence
package com.jntm.q2.driver;

public class Main {

	public static void main(String[] args) {
		//Show the first 25 fibonacci numbers including 0;
		fibonacci(0,1);

	}

	public static int fibonacci(int a, int b){
		//Basic recursion, just keep adding the values onto eachother.
		//I happen to know the 25th fibonacci value, but 
		//a better solution would probably involve passing
		//a third integer to act as a counter.
		if(a>46368){
			return 0;
		}
		System.out.print(a+" ");
		
		fibonacci(b,a+b);
		return 0;
		
	}
}
