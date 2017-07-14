package com.bc.q2.driver;

public class Driver {

	public static void fibonachi25(){
		int x = 1;
		int y = 1;
		int z = x + y;
		// print out the first two values
		System.out.println(x);
		System.out.println(y);
		
		// non recursive version of Fibonachi
		for(int i = 0 ; i < 23; i++){
			System.out.println(z);
			x = y;
			y = z;
			z = x + y;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver.fibonachi25();
	}

}
