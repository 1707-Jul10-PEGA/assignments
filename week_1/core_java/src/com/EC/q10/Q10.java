package com.EC.q10;

public class Q10 {

	public static void main(String[] args) {
		int int1=10,int2=20;
		System.out.println(min(int1,int2));
		System.out.println(min(int2,int1));
		System.out.println(min(int1,int1));
	}
	
	public static int min(int int1,int int2){
		//variable x = (expression) ? value if true : value if false
		return (int1<int2)?int1:int2;		
	}

}
