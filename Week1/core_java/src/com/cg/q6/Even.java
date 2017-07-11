package com.cg.q6;

public class Even {
	public static boolean even(int x){
		int y = Math.round((float)x / 2 - x/2);
		
		if(y == 0){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println("Is " + n + " even? " + even(n));
	}
}
