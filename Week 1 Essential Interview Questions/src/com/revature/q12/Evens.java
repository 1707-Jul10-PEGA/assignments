package com.revature.q12;

public class Evens {
		public static void main(String[] args) {
			int[] myAr = new int[100];
			for(int x = 0; x < myAr.length; x++){
				myAr[x] = x + 1;
			}
			for(Integer x : myAr){
				if(x % 2 == 0){
					System.out.print(x + " ");
				}
			}
			
		}
		
}
