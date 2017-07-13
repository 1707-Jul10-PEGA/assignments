package com.revature.q13;

public class Triangle {
	public static void main(String[] args) {
			
		for(int y = 0; y < 4; y++){
			for(int x = 0; x < y+1; x++)
			{
				if(x %2 == 0){
					System.out.print("0");
				}
				else{
					System.out.print("1");
				}	
			}
			System.out.println();
		}
	}	
}