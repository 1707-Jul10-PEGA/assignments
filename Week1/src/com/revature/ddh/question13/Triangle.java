package com.revature.ddh.question13;

public class Triangle {
	
	public static void main(String[] args) {
		
		int count = 1;
		for(int i = 1; i < 8; i++) {
			
			
			if( count < 1) {
				System.out.println("");
				count = count + i ;
			}
			count--;
			if(i % 2 == 0) {
			System.out.print(1);
			}
			else System.out.print(0);
		}
	}

}
