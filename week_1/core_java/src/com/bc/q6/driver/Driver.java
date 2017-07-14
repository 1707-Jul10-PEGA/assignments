package com.bc.q6.driver;

public class Driver {
	
	public static boolean isEven(int x){
		// zero is even.
		//19 / 2 == 9 , 18 / 2 = 9. Since 19 produces 9 on both side of the != operator, it is odd
		// otherwise, it is even
		//return (x == 0) ?  true: ((x / 2) != ((x - 1) / 2));
		
		// Simply checks for the right most bit
		return (x & 1) == 0; 
	}
	public static void main(String[] args) {
		System.out.println(isEven(19));
	}

}
