package com.rb.q13.driver;

public class TrianglePrint {
	public static void main(String args[]){
		
		boolean zero = true;
		
		for(int i = 1; i <= 4; i++){
			
			for(int j = 0; j < i; j++){
				if(zero){
					System.out.print("0");
				}else{
					System.out.print("1");
				}
				zero = !zero;
			}
			System.out.println("");
		}
	}
}
