package com.hy.q10.driver;

public class Question10 {
	private int minVal(int a, int b){
		return a < b ? a:b;
	}
	public static void main(String[] args) {
		Question10 q10 = new Question10();
		System.out.println("minVal(18,5):" + q10.minVal(18, 5));
		System.out.println("minVal(12,55):" + q10.minVal(12,55));
		System.out.println("minVal(1,23):" + q10.minVal(1, 23));
		System.out.println("minVal(15,2):" + q10.minVal(15, 2));
	}
}
