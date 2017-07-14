package com.bc.q12.driver;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] intArr = new int[100];
		for(int i = 0; i < 100; i++){
			intArr[i] = i+1;
		}
		for(int x : intArr){
			System.out.println(x);
		}

	}

}
