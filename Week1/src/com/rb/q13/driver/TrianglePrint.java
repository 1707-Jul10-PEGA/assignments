package com.rb.q13.driver;

public class TrianglePrint {
	public static void main(String args[]){
		
		// start by printing a zero, output
		// alternates between 0 and 1. Each
		// line has one more number than
		// the previous, starting from one.
		boolean zero = true;
		
		for(int i = 1; i <= 4; i++){
			
			for(int j = 0; j < i; j++){
				// if you need a zero, print zero
				// else, print one. Both have a
				// space after them
				if(zero){
					System.out.print("0 ");
				}else{
					System.out.print("1 ");
				}
				zero = !zero;
			}
			// print two newline characters
			System.out.println("\n");
		}
	}
}
