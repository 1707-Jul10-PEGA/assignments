package com.cg.q6;

public class Even {
	
	//Check if the value enter is even 
	public boolean even(int x){
		
		//Rounds the value to the nearest integer
		int y = Math.round((float)x / 2 - x/2);
		
		//The number is even if it's 0
		if(y == 0){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		int n = 4;
		Even e = new Even();
		System.out.println("Is " + n + " even? " + e.even(n));
	}
}
