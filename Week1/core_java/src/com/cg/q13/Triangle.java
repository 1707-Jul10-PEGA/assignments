package com.cg.q13;

public class Triangle {
	public static void printTriangle(int n){
		boolean onOff = false;
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++){
				if(onOff){
					System.out.print("1");
					onOff = false;
				}else{
					System.out.print("0");
					onOff = true;
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args){
		printTriangle(4);
		printTriangle(5);
	}
}
